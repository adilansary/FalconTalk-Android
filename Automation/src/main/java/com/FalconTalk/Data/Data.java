package com.FalconTalk.Data;

import java.util.Arrays;
import java.util.List;

public class Data {
	public static final List<String> RouterList = Arrays.asList("Axxess", "CG-710 (Legacy)", "CG-710 (FC)","CNX-900","GDR","SDR");
	public static final List<String> RingGroupAxxess = Arrays.asList("VVIP","VIP","Guest");
	public static final List<String> RingGroupCgLegacy = Arrays.asList("VVIP","VIP","Pilot","Guest","Cabin");
	public static final List<String> RingGroupCgFC = Arrays.asList("VVIP","VIP","Pilot","Secretary","Guest","Cabin");
	public static final List<String> RingGroupCNX = Arrays.asList("Cabin","Cockpit","Cabin(Cabin mode)");
	public static final List<String> RingGroupGDR = Arrays.asList("Cabin","Cockpit","Cabin(Cabin mode)");
	public static final List<String> RingGroupSDR = Arrays.asList("VVIP","VIP","Pilot","Guest","Cabin");
	public static final List<String> RingGroupWithExtensionAxxess = Arrays.asList("VVIP\r\n" + "88");
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	public static final String PROFILE_STATUS_ONLINE = "ONLINE";
	public static final String PROFILE_STATUS_OFFLINE = "OFFLINE";
	public static final String AutoDiscoveryFailedNotice = "Please connect to the onboard wifi";
	public static final String PreExtension = "86";	
	public static final String PreRingGroup = "Guest";
	public static final String PreDisplayName = "SM-G975U";
	public static final String NavDrawerAccInfo = "Guest-86";
	public static final String NavDrawerAccInfo1 = "VIP-87";


}
