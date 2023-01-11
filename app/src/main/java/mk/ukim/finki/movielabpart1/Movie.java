package mk.ukim.finki.movielabpart1;

public class Movie {

    private String id,title,plot,director;

    public Movie(String id, String title, String plot, String director){
        this.id=id;
        this.title=title;
        this.plot=plot;
        this.director=director;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPlot() {
        return plot;
    }

    public String getDirector() {
        return director;
    }
}
