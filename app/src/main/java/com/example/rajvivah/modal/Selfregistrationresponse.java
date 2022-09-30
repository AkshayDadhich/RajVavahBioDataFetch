package com.example.rajvivah.modal;

public class Selfregistrationresponse {

    public String registeruser_id ,name,registeruser_mob,register_uid;

    public Selfregistrationresponse() {
    }

    public String getRegisteruser_id() {
        return registeruser_id;
    }

    public void setRegisteruser_id(String registeruser_id) {
        this.registeruser_id = registeruser_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisteruser_mob() {
        return registeruser_mob;
    }

    public void setRegisteruser_mob(String registeruser_mob) {
        this.registeruser_mob = registeruser_mob;
    }

    public String getRegister_uid() {
        return register_uid;
    }

    public void setRegister_uid(String register_uid) {
        this.register_uid = register_uid;
    }

    public static class CourseModel {

        private String course_name;
        private int course_rating;
        private int course_image;

        // Constructor
        public CourseModel(String course_name, int course_rating, int course_image) {
            this.course_name = course_name;
            this.course_rating = course_rating;
            this.course_image = course_image;
        }

        // Getter and Setter
        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public int getCourse_rating() {
            return course_rating;
        }

        public void setCourse_rating(int course_rating) {
            this.course_rating = course_rating;
        }

        public int getCourse_image() {
            return course_image;
        }

        public void setCourse_image(int course_image) {
            this.course_image = course_image;
        }
    }
}

