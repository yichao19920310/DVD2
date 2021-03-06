package com.TC25.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.TC25.bean.DVD;
import com.TC25.bean.LendRecord;
import com.TC25.bean.User;
import com.TC25.bizImpl.UserBizImpl;
import com.TC25.dao.UserDao;
import com.TC25.tools.DBHelper;

public class UserDaoImpl implements UserDao {
	
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet rSet;
	
	private DBHelper mDB;
	public UserDaoImpl() {
		mDB = new DBHelper();
		mConnection = mDB.getConnection();
	}
	

	//Ctrl + 1
	@Override
	public User getUserByUserAcc(String userAcc) throws SQLException {
	
		//--问号叫做占位符.
		String sql = "select * from UserList where userAcc = ?";
		
		//--通过连接获取PreparedStatement对象
		mStatement = mConnection.prepareStatement(sql);
		
		//--通过PreparedStatement对象给占位符做赋值操作
		mStatement.setString(1, userAcc);
		
		//--通过PreparedStatement调用方法来执行查询语句并获取结果集对象
		//executeQuery  是查询专用
		/*
		 * 如果查的到则结果集中有数据.否则结果集为null
		 */
		rSet = mStatement.executeQuery();
		if (!rSet.next()) {
			return null;
		}
		User u = new User();				
		u.setUserId(rSet.getInt("USERID"));	
		u.setUserAcc(rSet.getString("USERACC"));
		u.setUserName(rSet.getString("USERNAME"));	
		u.setUserPwd(rSet.getString("USERPWD"));
		u.setUserPwdTip(rSet.getString("USERPWDTIP"));
		u.setUserStatus(rSet.getInt("USERSTATUS"));
			
		return u;
	}


	@Override
	public boolean isUserAccExist(String userAcc) throws SQLException {
		String sql = "select * from UserList where userAcc = ?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, userAcc);
		rSet = mStatement.executeQuery();
		if (rSet.next()) {
			return true;
		}
		return false;
	}


	/* (非 Javadoc)  
	 * <p>Title: addUserToDataBase</p>  
	 * <p>Description: </p>  
	 * @param u
	 * @return
	 * @throws SQLException  
	 * @see com.TC25.dao.UserDao#addUserToDataBase(com.TC25.bean.User)  
	 */  
	@Override
	public boolean addUserToDataBase(User u) throws SQLException {
		String sql = "insert into UserList (userId,userAcc,userPwd,userName,userPwdTip)values(USERID_SEQ.nextval,?,?,?,?)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, u.getUserAcc());
		mStatement.setString(2, u.getUserPwd());
		mStatement.setString(3, u.getUserName());
		mStatement.setString(4, u.getUserPwdTip());
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}


	/* (非 Javadoc)  
	 * <p>Title: getAllDvd</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.dao.UserDao#getAllDvd()  
	 */  
	@Override
	public ArrayList<DVD> getDvdList(int i) throws SQLException {
		ArrayList<DVD> dvdList = new ArrayList<>();
		String sql = null;
		if(i == 1) {
			sql = "select * from DVDList where DVDSTATUS = 1 or DVDSTATUS = 2";
		}else if(i == 2) {
			sql = "select * from DVDList where DVDSTATUS = 1";
		}else {
			sql = "select * from DVDList where DVDSTATUS = 2";
		}
		
		
		mStatement = mConnection.prepareStatement(sql);
		rSet = mStatement.executeQuery();
		while(rSet.next()) {
			DVD dvd = new DVD();
			dvd.setDvdId(rSet.getInt("DVDID"));
			dvd.setDvdName(rSet.getString("DVDNAME"));
			dvd.setDvdDate(rSet.getDate("DVDDATE"));
			dvd.setDvdLendCount(rSet.getInt("DVDLENDCOUNT"));
			dvd.setDvdStatus(rSet.getInt("DVDSTATUS"));
			dvdList.add(dvd);
		}
		return dvdList;
	}


	/* (非 Javadoc)  
	 * <p>Title: lendDvd</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return  
	 * @see com.TC25.dao.UserDao#lendDvd(int)  
	 */  
	@Override
	public boolean lendDvd(int id) throws SQLException {
		String sql1 = "update DVDList set DVDStatus = 2,DVDLendCount = (select dvdlendcount from dvdlist where dvdid =?)+1 where DVDStatus = 1 and DVDID = ?";
		mStatement = mConnection.prepareStatement(sql1);
		mStatement.setInt(1, id);
		mStatement.setInt(2, id);
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		String sql2 = "insert into LendRecordList (lrId,lrNumber,DVDId,DVDName,LendDate,RetuDate,UserID)"
				+ " values(lrid_seq.nextval,'AA'|| (substr(cast(dbms_random.value as varchar2(50)),3,4))"
				+ "||(lpad(cast(lrid_seq.currval as varchar2(50)),3,0)),?,(select dvdname from dvdlist where dvdid = ?),SYSDATE,SYSDATE+7,?) ";
		mStatement = mConnection.prepareStatement(sql2);
		mStatement.setInt(1, id);
		mStatement.setInt(2, id);
		mStatement.setInt(3, UserBizImpl.mUser.getUserId());
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}


	@Override
	public ArrayList<LendRecord> getLrByUser() throws SQLException {
		String sql = "select * from LENDRECORDLIST " 
				+"where userid = ? and lrstatus = 0 ";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, UserBizImpl.mUser.getUserId());
		rSet = mStatement.executeQuery();
		ArrayList<LendRecord> lrList = new ArrayList<>();
		while(rSet.next()) {
			LendRecord lr = new LendRecord();
			lr.setDvdId(rSet.getInt("DVDID"));
			lr.setDvdName(rSet.getString("DVDNAME"));
			lr.setLendDate(rSet.getDate("LENDDATE"));
			lr.setRetuDate(rSet.getDate("RETUDATE"));
			lr.setLrId(rSet.getInt("LRID"));
			lr.setLrNumber(rSet.getString("LRNUMBER"));
			lr.setLrStatus(rSet.getInt("LRSTATUS"));
			lr.setUserId(rSet.getInt("USERID"));
			lrList.add(lr);
		}
		if(lrList.size()!=0) {
			return lrList;
		}
		return null;
	}


	/* (非 Javadoc)  
	 * <p>Title: RetuDvd</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return
	 * @throws SQLException  
	 * @see com.TC25.dao.UserDao#RetuDvd(int)  
	 */  
	@Override
	public boolean RetuDvd(int id) throws SQLException {
		String sql1 = "update dvdlist set dvdStatus = 1 where dvdid = ? and dvdStatus = 2";
		mStatement = mConnection.prepareStatement(sql1);
		mStatement.setInt(1, id);
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		String sql2 = "update lendrecordlist set lrstatus = 1 where dvdid = ? and lrstatus = 0";
		mStatement = mConnection.prepareStatement(sql2);
		mStatement.setInt(1, id);
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}


	/* (非 Javadoc)  
	 * <p>Title: addDvd</p>  
	 * <p>Description: </p>  
	 * @param dvdName
	 * @return  
	 * @see com.TC25.dao.UserDao#addDvd(java.lang.String)  
	 */  
	@Override
	public boolean addDvd(String dvdName) throws SQLException {
		String sql = "insert into dvdlist (dvdid,dvdname,dvddate) values (dvdid_seq.nextval,?,SYSDATE)";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setString(1, dvdName);
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		
		return true;
	}


	/* (非 Javadoc)  
	 * <p>Title: subDvd</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @return
	 * @throws SQLException  
	 * @see com.TC25.dao.UserDao#subDvd(int)  
	 */  
	@Override
	public boolean subDvd(int id) throws SQLException {
		String sql = "update dvdlist set dvdstatus = 3 where dvdid = ?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, id);
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}


	/* (非 Javadoc)  
	 * <p>Title: changeUserStatus</p>  
	 * <p>Description: </p>  
	 * @param i
	 * @return
	 * @throws SQLException  
	 * @see com.TC25.dao.UserDao#changeUserStatus(int)  
	 */  
	@Override
	public boolean changeUserStatus(int status) throws SQLException {
		String sql = "update userlist set userstatus = ? where userid = ?";
		mStatement = mConnection.prepareStatement(sql);
		mStatement.setInt(1, status);
		mStatement.setInt(2, UserBizImpl.mUser.getUserId());
		if(0 == mStatement.executeUpdate()) {
			return false;
		}
		return true;
	}

}













