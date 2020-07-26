public class Video {

	private int id;
	private String name;
	private String categoria;
	
	public Video (int id, String name, String categoria) {
		this.id = id;
		this.name = name;
		this.categoria = categoria;

	}
	
	public int get_id () {
		return this.id;
	}
	
	public String get_name () {
		return this.name;
	}
	
	public String get_categoria () {
		return this.categoria;
	}
	

	
	public void set_name (String new_name) {
		this.name = new_name;
	}
	
	
	public void set_categoria (String new_categoria) {
		this.categoria = new_categoria;
	}
	
	public void to_String () {
		StringBuilder sb = new StringBuilder ();
		sb.append("Vídeo: " + this.get_name() 	+ "\n");
		sb.append("Categoria: " + this.get_categoria() + "\n");
		
		System.out.println(sb);
		
	}
	
}