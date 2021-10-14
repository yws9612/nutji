package org.techtown.dontlate;

public class UsersJob {
    public String job;

    public UsersJob() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UsersJob(String job) {
        this.job = job;
    }

    public String getUserJob() {
        return job;
    }

    public void setUserJob(String job) {
        this.job = job;
    }


    @Override
    public String toString() {
        return "UsersJob{" +
                "job='" +job +'\'' + '}';
    }
}
