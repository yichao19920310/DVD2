package com.TC25.bizImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.TC25.bean.DVD;
import com.TC25.bean.User;
import com.TC25.biz.UserBiz;
import com.TC25.dao.UserDao;
import com.TC25.daoImpl.UserDaoImpl;

public class UserBizImpl implements UserBiz {

	public static User mUser;
	UserDao ud = new UserDaoImpl();
	@Override
	public boolean userLogin(String userAcc, String userPwd) {
	
		if (userAcc == null || userPwd == null || userAcc.length() == 0 || userPwd.length() == 0) {
			return false;
		}
		
		
		try {
			mUser = ud.getUserByUserAcc(userAcc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (mUser == null) {
			return false;
		}
		
		//--开始验证密码
		if(userPwd.equals(mUser.getUserPwd())) {
			return true;
		}
		return false;
		
		
		
	}
	@Override
	public boolean checkUserAcc(String userAcc) {
		if (userAcc == null || userAcc.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z0-9_.]{5,15}");
		Matcher m = p.matcher(userAcc);
		try {
			if (m.matches() && !ud.isUserAccExist(userAcc)) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean userRegist(String userAcc, String userPwd, String userName, String userPwdTip) {
		User u = new User(userAcc,userName,userPwd,userPwdTip);
		boolean isSuccess = false;
		try {
			isSuccess = ud.addUserToDataBase(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	@Override
	public boolean checkUserPwd(String userPwd) {
		if (userPwd == null || userPwd.length() == 0) {
			return false;
		}
		Pattern p = Pattern.compile("[a-zA-Z0-9_.*]{6,16}");
		Matcher m = p.matcher(userPwd);
		if(m.matches()) {
			return true;
		}
		return false;
	}
	@Override
	public void getUserInfo() {
		try {
			mUser = ud.getUserByUserAcc(mUser.getUserAcc());
			System.out.println(mUser.toString());			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (非 Javadoc)  
	 * <p>Title: showAllDvd</p>  
	 * <p>Description: </p>    
	 * @see com.TC25.biz.UserBiz#showAllDvd()  
	 */  
	@Override
	public ArrayList<DVD> showDvd(int i) {
		ArrayList<DVD> dvdList = null;
		try {
			dvdList = ud.getDvdList(i);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (DVD dvd : dvdList) {
			System.out.println(dvd.toString());
		}
		return dvdList;
		
	}
	/* (非 Javadoc)  
	 * <p>Title: lendDvd</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see com.TC25.biz.UserBiz#lendDvd()  
	 */  
	@Override
	public boolean lendDvd(int id) {
		boolean b = false;
		try {
			b = ud.lendDvd(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	/* (非 Javadoc)  
	 * <p>Title: checkDvdIdLendable</p>  
	 * <p>Description: </p>  
	 * @param id
	 * @param dvdList
	 * @return  
	 * @see com.TC25.biz.UserBiz#checkDvdIdLendable(int, java.util.ArrayList)  
	 */  
	@Override
	public boolean checkDvdIdLendable(int id, ArrayList<DVD> dvdList) {
		for (DVD dvd : dvdList) {
			if(id == dvd.getDvdId()) {
				System.out.println(dvd.toString());
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean checkReturnableDvd() {
		ArrayList<DVD> dvdList = null;
		try {
			dvdList = ud.getDvdByUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dvdList != null) {
			for (DVD dvd : dvdList) {
				System.out.println("dvdId:"+dvd.getDvdId()+"\tdvdName:"+dvd.getDvdName());
			}
		}else {
			return false;
		}
		return true;
	}
	@Override
	public boolean RetuDvdById(int id) {
		ArrayList<DVD> dvdList = null;
		boolean b = false;
		try {
			dvdList = ud.getDvdByUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dvdList != null) {
			for (DVD dvd : dvdList) {
				if(id == dvd.getDvdId()) {
					try {
						b = ud.RetuDvd(id);
						break;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}else {
			return false;
		}
		return b;
	}
	/* (非 Javadoc)  
	 * <p>Title: addDvd</p>  
	 * <p>Description: </p>  
	 * @param dvdName
	 * @return  
	 * @see com.TC25.biz.UserBiz#addDvd(java.lang.String)  
	 */  
	@Override
	public boolean addDvd(String dvdName) {
		if(dvdName == null || dvdName.length() ==0) {
			return false;
		}
		boolean b = false;
		try {
			b = ud.addDvd(dvdName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	/* (非 Javadoc)  
	 * <p>Title: subDvd</p>  
	 * <p>Description: </p>  
	 * @param dvdId
	 * @return  
	 * @see com.TC25.biz.UserBiz#subDvd(int)  
	 */  
	@Override
	public boolean subDvd(int id) {
		boolean b = false;
		try {
			b = ud.subDvd(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	

}
