package com.app.daos;

import java.util.List;

import com.app.pojos.PoliceAdd;
import com.app.pojos.UserAdd;
import com.app.pojos.VicAdd;
import com.app.pojos.Victim;

public interface IPoliceDao 
{
	public VicAdd registerCase(VicAdd v);
	public List<VicAdd> showAllCases();
	public List<Victim> searchByName(String name);
	public PoliceAdd addPolice(PoliceAdd p);
	public UserAdd editPolice(Integer id,UserAdd p);
}
