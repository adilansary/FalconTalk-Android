package com.FalconTalk.Data;

import java.util.Arrays;
import java.util.List;

public class ProfileDetailsData {
	public static final List<String> ManufacturerList = Arrays.asList("Gogo","Honeywell","Satcom Direct","Custom");
	public static final String CabinPage = "Select a Cabin Account";
	public static final String CabinRouterNameforSatcom = "SDR";
	public static final List<String> CabinRouterNameforHonwywell = Arrays.asList("CG-710 (Legacy)","CG-710 (FC)","CNX-900","GDR");
	public static final String CabinRouternameforgogo = "Axxess";
	public static final String CabinRouterNameforCustom = "Custom";
	public static final String RingGroupDispName = "SM-G975U";
	public static final String RingGroupPage = "Please select an user type and extension";
	public static final String DomainNameAxxess = "192.168.1.200";
	public static final String DomainNameSDR = "sdr.local";
	public static final List<String> DomainNameHoneywell = Arrays.asList("vpm","godirect");
	public static final List<String> RingGroupforGogoAxxess = Arrays.asList("VVIP","VIP","Guest");
	public static final List<String> RingGroupforHoneywellLegacy = Arrays.asList("VVIP","VIP","Pilot","Guest");
	public static final List<String> GingGroupforHoneywellFC = Arrays.asList("VVIP","VIP","Pilot","Secretary","Guest");
	public static final List<String> GingGroupforHoneywellCNX = Arrays.asList("Cabin","Cockpit");
	public static final List<String> GingGroupforHoneywellGDR = Arrays.asList("Cabin","Cockpit");
	public static final List<String> GingGroupforSatcomSDR = Arrays.asList("VVIP","VIP","Pilot","Guest");
	public static final List<String> AccountStatus = Arrays.asList("Registered","Not Registered","Disabled");
	
	//Data for Custom Account
	
	public static final String DomainNameCustom = "202.191.126.148";
	public static final List<String> ExtensionListOnProfile =Arrays.asList("218 (SIP)","220 (SIP)");
	public static final List<String> ExtensionCustom =Arrays.asList("218","220");
	public static final  List<String> passwordCustom = Arrays.asList("1234","1212");

}
