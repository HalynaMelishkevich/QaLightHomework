package automation.melishkevich;

public class UrlBuilder {
	String market, environment;

	public UrlBuilder() {
		try {
			market = ConfigData.getCfgValue("MARKET");
			environment = ConfigData.getCfgValue("ENVIRONMENT");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String builMipUrl() {
		if (environment.toLowerCase().equals("qa") || environment.toLowerCase().equals("staging")) {
			return "https://" + market + "." + environment + "-ekatbackend.com/";
		} else {
			return "https://" + market + ".ekatbackend.com/";
		}
	}

	public String builStsUrl() {
		if (environment.toLowerCase().equals("qa")) {
			return "https://" + market + "." + environment + "-stsmip.com/";
		} else if (environment.toLowerCase().equals("staging")) {
			return "https://" + market + ".stg-stsmip.com/";
		} else {
			return "https://" + market + ".stsmip.com/";
		}
	}

	public String builFotUrl() {
		if (environment.toLowerCase().equals("qa") || environment.toLowerCase().equals("staging")) {
			return "https://" + market + ".fot-" + environment + "-ekatbackend.com/";
		} else {
			return "https://" + market + ".fot-ekatbackend.com/";
		}
	}
}
