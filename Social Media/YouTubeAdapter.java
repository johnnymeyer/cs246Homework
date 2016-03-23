package socialmedia;

public class YouTubeAdapter implements SocialMediaEntry {
	
	YouTubeVideo yourTube;

	public YouTubeAdapter(YouTubeVideo myTube) {
		yourTube = myTube;
	}

	public String getUser() {
		return yourTube.getAuthor();
	}

	public String getPostText() {
		String textPost;

		textPost = yourTube.getTitle();
		textPost += ": ";
		textPost += yourTube.getDescription();

		return textPost;
	}
}