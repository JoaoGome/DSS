public class Music {

	private int id;
	private String name;
	private String singer;
	private String categoria;
	private String album;
	private int ordem_album;
	
	
	public Music (int music_id, String name, String singer, String categoria, String album, int ordem_album) {
		this.id = music_id;
		this.name = name;
		this.singer = singer;
		this.categoria = categoria;
		this.album = album;
		this.ordem_album = ordem_album;
		
	}
	
	public String get_name () {
		return this.name;
	}
	
	public String get_singer () {
		return this.singer;
	}
	
	public String get_categoria () {
		return this.categoria;
	}
	
	public String get_album () {
		return this.album;
	}
	
	public int get_ordemAlbum () {
		return this.ordem_album;
	}
	
	public int get_musicID () {
		return this.id;
	}
	
	
	public void set_name (String new_name) {
		this.name = new_name;
	}
	
	public void set_singer (String new_singer) {
		this.singer = new_singer;
	}
	
	public void set_categoria (String new_categoria) {
		this.categoria = new_categoria;
	}
	
	public void set_ordemAlbum (int ordem) {
		this.ordem_album = ordem;
	}
	
	
	public void to_String () {
		StringBuilder sb = new StringBuilder ();
		sb.append("Música: " + this.get_name() 	+ "\n");
		sb.append("Autor: " + this.get_singer() + "\n");
		sb.append("Categoria: " + this.get_categoria() + "\n");
		
		System.out.println(sb);
		
	}
	
}
