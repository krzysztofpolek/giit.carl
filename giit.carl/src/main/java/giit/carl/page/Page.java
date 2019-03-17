package giit.carl.page;

public class Page {

	private String header;
	private String body;
	
	public Page(String header, String body) {
		super();
		this.header = header;
		this.body = body;
	}
	
	public void build() {
		
		System.out.println("");
		System.out.println(this.header);
		System.out.print("\t" + this.body);
		
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Page [header=" + header + ", body=" + body + "]";
	}
	
}
