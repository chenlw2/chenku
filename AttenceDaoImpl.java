package cn.com.wuqi.dao.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.wuqi.dao.AttenceDao;
import cn.com.wuqi.dao.BaseDao;
import cn.com.wuqi.entity.Attence;

public class AttenceDaoImpl extends BaseDao implements AttenceDao {

	public AttenceDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Attence> showAttence() throws SQLException {
		List<Attence> list = new ArrayList<Attence>();
		String sql = "SELECT * FROM  `attence`  ORDER BY `CHKDATE` DESC";
		ResultSet rs = executeQuer(sql);
		while (rs.next()) {
			Attence person = new Attence(rs.getInt(1),rs.getString(2),
					rs.getString(3),rs.getDate(4), rs.getString(5)
					);
			list.add(person);
		}
		System.out.println("∑√Œ ≤„list£∫"+list.size());
		return list;
	}

	@Override
	public int addAttence(Attence attence) throws SQLException {
		int result = 0;
		String sql ="INSERT INTO `attence` (`EMPNAME`,`DEPT`,`CHKDATE`,`STATUS`)VALUE(?,?,?,?)";
		result=executeUdate(sql,attence.getEMPNAME(),attence.getDEPT(),attence.getCHKDATE(),attence.getSTATUS());
		System.out.println("ÃÌº”∑√Œ ≤„result:"+result);
		return result;
	}

}
