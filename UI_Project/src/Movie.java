public class Movie {

		private String movieName, genre, videoType;
		
		public String getmovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getVideoType() {
			return videoType;
		}

		public void setVideoType(String videoType) {
			this.videoType = videoType;
		}

		public Movie() {
			movieName = " ";
			genre = "";
			videoType ="";
			
			
		}
		//Constructor
		Movie (String movieName, String genre, String videoType){
			setMovieName(movieName);
			setGenre(genre);
			setVideoType(videoType);
			
		}
		

		@Override
		public String toString(){
			return String.format("%s %s %s ", movieName, genre,videoType);
		}
	}