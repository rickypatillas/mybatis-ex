package com.springrest.model.nyt;

public class NYT_Top {

    String status;
    String copyright;
    String section;
    String last_updated;
    int num_results;
    TopStories[] results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoppyright() {
        return copyright;
    }

    public void setCoppyright(String coppyright) {
        this.copyright = coppyright;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public TopStories[] getResults() {
        return results;
    }

    public void setResults(TopStories[] results) {
        this.results = results;
    }
}
