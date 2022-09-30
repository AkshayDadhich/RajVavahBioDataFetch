package com.example.rajvivah.modal;

public class RegistrationModel {
String  registeruser_id, name, fathername, mothername, grandfathername, candidate_cast, candidate_gotra, registeruser_mob, candidate_mob, candidate_mail, candidate_address, candidate_post, candidate_teh, candidate_dist, candidate_state, candidate_country, candidate_polstation, candidate_pin, candidate_name_of_fatherinlaw, candidate_cast_of_fatherinlaw, candidate_gotra_of_fatherinlaw, candidate_address_of_fatherinlaw, candidate_post_of_fatherinlaw, candidate_teh_of_fatherinlaw, candidate_polstation_of_fatherinlaw, candidate_dist_of_fatherinlaw, candidate_state_of_fatherinlaw, candidate_country_of_fatherinlaw, candidate_pin_of_fatherinlaw, candidate_name_of_nanosa, candidate_cast_of_nanihal, candidate_gotra_of_nanihal, candidate_address_of_nanihal, candidate_post_of_nanihal, candidate_teh_of_nanihal, candidate_polstation_of_nanihal, candidate_dist_of_nanihal, candidate_state_of_nanihal, candidate_country_of_nanihal, candidate_pin_of_nanihal, candidate_name_of_dadera, candidate_cast_of_dadera, candidate_gotra_of_dadera, candidate_address_of_dadera, candidate_post_of_dadera, candidate_teh_of_dadera, candidate_polstation_of_dadera, candidate_dist_of_dadera, candidate_state_of_dadera, candidate_country_of_dadera, candidate_pin_of_dadera,   tenth_board,   tenth_per,   twelth_board,   tenth_sub,   twelth_per,   gradu_uni,   gradu_sub,   gradu_per,   pg_uni,   pg_sub,   pg_per,   other_edu,   other_edu_per,   other_edu_sub,   job,   job_department,   job_from,   image,
 dahejoth_descrip, brother, sister, married, son, daughter, marriedchild, path, gender_self, refrencename, refrencenamE_MOB;
Boolean  dahejoth =true;
int candidate_son , candidate_daughter ;

// Constructor of modal class

    public RegistrationModel() {
    }

    public RegistrationModel(String registeruser_id, String name, String fathername, String mothername, String grandfathername, String candidate_cast, String candidate_gotra, String registeruser_mob, String candidate_mob, String candidate_mail, String candidate_address, String candidate_post, String candidate_teh, String candidate_dist, String candidate_state, String candidate_country, String candidate_polstation, String candidate_pin, String candidate_name_of_fatherinlaw, String candidate_cast_of_fatherinlaw, String candidate_gotra_of_fatherinlaw, String candidate_address_of_fatherinlaw, String candidate_post_of_fatherinlaw, String candidate_teh_of_fatherinlaw, String candidate_polstation_of_fatherinlaw, String candidate_dist_of_fatherinlaw, String candidate_state_of_fatherinlaw, String candidate_country_of_fatherinlaw, String candidate_pin_of_fatherinlaw, String candidate_name_of_nanosa, String candidate_cast_of_nanihal, String candidate_gotra_of_nanihal, String candidate_address_of_nanihal, String candidate_post_of_nanihal, String candidate_teh_of_nanihal, String candidate_polstation_of_nanihal, String candidate_dist_of_nanihal, String candidate_state_of_nanihal, String candidate_country_of_nanihal, String candidate_pin_of_nanihal, String candidate_name_of_dadera, String candidate_cast_of_dadera, String candidate_gotra_of_dadera, String candidate_address_of_dadera, String candidate_post_of_dadera, String candidate_teh_of_dadera, String candidate_polstation_of_dadera, String candidate_dist_of_dadera, String candidate_state_of_dadera, String candidate_country_of_dadera, String candidate_pin_of_dadera, String tenth_board, String tenth_per, String twelth_board, String tenth_sub, String twelth_per, String gradu_uni, String gradu_sub, String gradu_per, String pg_uni, String pg_sub, String pg_per, String other_edu, String other_edu_per, String other_edu_sub, String job, String job_department, String job_from, String image, String dahejoth_descrip, String brother, String sister, String married, String son, String daughter, String marriedchild, String path, String gender_self, String refrencename, String refrencenamE_MOB, Boolean dahejoth, int candidate_son, int candidate_daughter) {
        this.registeruser_id = registeruser_id;
        this.name = name;
        this.fathername = fathername;
        this.mothername = mothername;
        this.grandfathername = grandfathername;
        this.candidate_cast = candidate_cast;
        this.candidate_gotra = candidate_gotra;
        this.registeruser_mob = registeruser_mob;
        this.candidate_mob = candidate_mob;
        this.candidate_mail = candidate_mail;
        this.candidate_address = candidate_address;
        this.candidate_post = candidate_post;
        this.candidate_teh = candidate_teh;
        this.candidate_dist = candidate_dist;
        this.candidate_state = candidate_state;
        this.candidate_country = candidate_country;
        this.candidate_polstation = candidate_polstation;
        this.candidate_pin = candidate_pin;
        this.candidate_name_of_fatherinlaw = candidate_name_of_fatherinlaw;
        this.candidate_cast_of_fatherinlaw = candidate_cast_of_fatherinlaw;
        this.candidate_gotra_of_fatherinlaw = candidate_gotra_of_fatherinlaw;
        this.candidate_address_of_fatherinlaw = candidate_address_of_fatherinlaw;
        this.candidate_post_of_fatherinlaw = candidate_post_of_fatherinlaw;
        this.candidate_teh_of_fatherinlaw = candidate_teh_of_fatherinlaw;
        this.candidate_polstation_of_fatherinlaw = candidate_polstation_of_fatherinlaw;
        this.candidate_dist_of_fatherinlaw = candidate_dist_of_fatherinlaw;
        this.candidate_state_of_fatherinlaw = candidate_state_of_fatherinlaw;
        this.candidate_country_of_fatherinlaw = candidate_country_of_fatherinlaw;
        this.candidate_pin_of_fatherinlaw = candidate_pin_of_fatherinlaw;
        this.candidate_name_of_nanosa = candidate_name_of_nanosa;
        this.candidate_cast_of_nanihal = candidate_cast_of_nanihal;
        this.candidate_gotra_of_nanihal = candidate_gotra_of_nanihal;
        this.candidate_address_of_nanihal = candidate_address_of_nanihal;
        this.candidate_post_of_nanihal = candidate_post_of_nanihal;
        this.candidate_teh_of_nanihal = candidate_teh_of_nanihal;
        this.candidate_polstation_of_nanihal = candidate_polstation_of_nanihal;
        this.candidate_dist_of_nanihal = candidate_dist_of_nanihal;
        this.candidate_state_of_nanihal = candidate_state_of_nanihal;
        this.candidate_country_of_nanihal = candidate_country_of_nanihal;
        this.candidate_pin_of_nanihal = candidate_pin_of_nanihal;
        this.candidate_name_of_dadera = candidate_name_of_dadera;
        this.candidate_cast_of_dadera = candidate_cast_of_dadera;
        this.candidate_gotra_of_dadera = candidate_gotra_of_dadera;
        this.candidate_address_of_dadera = candidate_address_of_dadera;
        this.candidate_post_of_dadera = candidate_post_of_dadera;
        this.candidate_teh_of_dadera = candidate_teh_of_dadera;
        this.candidate_polstation_of_dadera = candidate_polstation_of_dadera;
        this.candidate_dist_of_dadera = candidate_dist_of_dadera;
        this.candidate_state_of_dadera = candidate_state_of_dadera;
        this.candidate_country_of_dadera = candidate_country_of_dadera;
        this.candidate_pin_of_dadera = candidate_pin_of_dadera;
        this.tenth_board = tenth_board;
        this.tenth_per = tenth_per;
        this.twelth_board = twelth_board;
        this.tenth_sub = tenth_sub;
        this.twelth_per = twelth_per;
        this.gradu_uni = gradu_uni;
        this.gradu_sub = gradu_sub;
        this.gradu_per = gradu_per;
        this.pg_uni = pg_uni;
        this.pg_sub = pg_sub;
        this.pg_per = pg_per;
        this.other_edu = other_edu;
        this.other_edu_per = other_edu_per;
        this.other_edu_sub = other_edu_sub;
        this.job = job;
        this.job_department = job_department;
        this.job_from = job_from;
        this.image = image;
        this.dahejoth_descrip = dahejoth_descrip;
        this.brother = brother;
        this.sister = sister;
        this.married = married;
        this.son = son;
        this.daughter = daughter;
        this.marriedchild = marriedchild;
        this.path = path;
        this.gender_self = gender_self;
        this.refrencename = refrencename;
        this.refrencenamE_MOB = refrencenamE_MOB;
        this.dahejoth = dahejoth;
        this.candidate_son = candidate_son;
        this.candidate_daughter = candidate_daughter;
    }


// All Getter Setters are below
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

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getGrandfathername() {
        return grandfathername;
    }

    public void setGrandfathername(String grandfathername) {
        this.grandfathername = grandfathername;
    }

    public String getCandidate_cast() {
        return candidate_cast;
    }

    public void setCandidate_cast(String candidate_cast) {
        this.candidate_cast = candidate_cast;
    }

    public String getCandidate_gotra() {
        return candidate_gotra;
    }

    public void setCandidate_gotra(String candidate_gotra) {
        this.candidate_gotra = candidate_gotra;
    }

    public String getRegisteruser_mob() {
        return registeruser_mob;
    }

    public void setRegisteruser_mob(String registeruser_mob) {
        this.registeruser_mob = registeruser_mob;
    }

    public String getCandidate_mob() {
        return candidate_mob;
    }

    public void setCandidate_mob(String candidate_mob) {
        this.candidate_mob = candidate_mob;
    }

    public String getCandidate_mail() {
        return candidate_mail;
    }

    public void setCandidate_mail(String candidate_mail) {
        this.candidate_mail = candidate_mail;
    }

    public String getCandidate_address() {
        return candidate_address;
    }

    public void setCandidate_address(String candidate_address) {
        this.candidate_address = candidate_address;
    }

    public String getCandidate_post() {
        return candidate_post;
    }

    public void setCandidate_post(String candidate_post) {
        this.candidate_post = candidate_post;
    }

    public String getCandidate_teh() {
        return candidate_teh;
    }

    public void setCandidate_teh(String candidate_teh) {
        this.candidate_teh = candidate_teh;
    }

    public String getCandidate_dist() {
        return candidate_dist;
    }

    public void setCandidate_dist(String candidate_dist) {
        this.candidate_dist = candidate_dist;
    }

    public String getCandidate_state() {
        return candidate_state;
    }

    public void setCandidate_state(String candidate_state) {
        this.candidate_state = candidate_state;
    }

    public String getCandidate_country() {
        return candidate_country;
    }

    public void setCandidate_country(String candidate_country) {
        this.candidate_country = candidate_country;
    }

    public String getCandidate_polstation() {
        return candidate_polstation;
    }

    public void setCandidate_polstation(String candidate_polstation) {
        this.candidate_polstation = candidate_polstation;
    }

    public String getCandidate_pin() {
        return candidate_pin;
    }

    public void setCandidate_pin(String candidate_pin) {
        this.candidate_pin = candidate_pin;
    }

    public String getCandidate_name_of_fatherinlaw() {
        return candidate_name_of_fatherinlaw;
    }

    public void setCandidate_name_of_fatherinlaw(String candidate_name_of_fatherinlaw) {
        this.candidate_name_of_fatherinlaw = candidate_name_of_fatherinlaw;
    }

    public String getCandidate_cast_of_fatherinlaw() {
        return candidate_cast_of_fatherinlaw;
    }

    public void setCandidate_cast_of_fatherinlaw(String candidate_cast_of_fatherinlaw) {
        this.candidate_cast_of_fatherinlaw = candidate_cast_of_fatherinlaw;
    }

    public String getCandidate_gotra_of_fatherinlaw() {
        return candidate_gotra_of_fatherinlaw;
    }

    public void setCandidate_gotra_of_fatherinlaw(String candidate_gotra_of_fatherinlaw) {
        this.candidate_gotra_of_fatherinlaw = candidate_gotra_of_fatherinlaw;
    }

    public String getCandidate_address_of_fatherinlaw() {
        return candidate_address_of_fatherinlaw;
    }

    public void setCandidate_address_of_fatherinlaw(String candidate_address_of_fatherinlaw) {
        this.candidate_address_of_fatherinlaw = candidate_address_of_fatherinlaw;
    }

    public String getCandidate_post_of_fatherinlaw() {
        return candidate_post_of_fatherinlaw;
    }

    public void setCandidate_post_of_fatherinlaw(String candidate_post_of_fatherinlaw) {
        this.candidate_post_of_fatherinlaw = candidate_post_of_fatherinlaw;
    }

    public String getCandidate_teh_of_fatherinlaw() {
        return candidate_teh_of_fatherinlaw;
    }

    public void setCandidate_teh_of_fatherinlaw(String candidate_teh_of_fatherinlaw) {
        this.candidate_teh_of_fatherinlaw = candidate_teh_of_fatherinlaw;
    }

    public String getCandidate_polstation_of_fatherinlaw() {
        return candidate_polstation_of_fatherinlaw;
    }

    public void setCandidate_polstation_of_fatherinlaw(String candidate_polstation_of_fatherinlaw) {
        this.candidate_polstation_of_fatherinlaw = candidate_polstation_of_fatherinlaw;
    }

    public String getCandidate_dist_of_fatherinlaw() {
        return candidate_dist_of_fatherinlaw;
    }

    public void setCandidate_dist_of_fatherinlaw(String candidate_dist_of_fatherinlaw) {
        this.candidate_dist_of_fatherinlaw = candidate_dist_of_fatherinlaw;
    }

    public String getCandidate_state_of_fatherinlaw() {
        return candidate_state_of_fatherinlaw;
    }

    public void setCandidate_state_of_fatherinlaw(String candidate_state_of_fatherinlaw) {
        this.candidate_state_of_fatherinlaw = candidate_state_of_fatherinlaw;
    }

    public String getCandidate_country_of_fatherinlaw() {
        return candidate_country_of_fatherinlaw;
    }

    public void setCandidate_country_of_fatherinlaw(String candidate_country_of_fatherinlaw) {
        this.candidate_country_of_fatherinlaw = candidate_country_of_fatherinlaw;
    }

    public String getCandidate_pin_of_fatherinlaw() {
        return candidate_pin_of_fatherinlaw;
    }

    public void setCandidate_pin_of_fatherinlaw(String candidate_pin_of_fatherinlaw) {
        this.candidate_pin_of_fatherinlaw = candidate_pin_of_fatherinlaw;
    }

    public String getCandidate_name_of_nanosa() {
        return candidate_name_of_nanosa;
    }

    public void setCandidate_name_of_nanosa(String candidate_name_of_nanosa) {
        this.candidate_name_of_nanosa = candidate_name_of_nanosa;
    }

    public String getCandidate_cast_of_nanihal() {
        return candidate_cast_of_nanihal;
    }

    public void setCandidate_cast_of_nanihal(String candidate_cast_of_nanihal) {
        this.candidate_cast_of_nanihal = candidate_cast_of_nanihal;
    }

    public String getCandidate_gotra_of_nanihal() {
        return candidate_gotra_of_nanihal;
    }

    public void setCandidate_gotra_of_nanihal(String candidate_gotra_of_nanihal) {
        this.candidate_gotra_of_nanihal = candidate_gotra_of_nanihal;
    }

    public String getCandidate_address_of_nanihal() {
        return candidate_address_of_nanihal;
    }

    public void setCandidate_address_of_nanihal(String candidate_address_of_nanihal) {
        this.candidate_address_of_nanihal = candidate_address_of_nanihal;
    }

    public String getCandidate_post_of_nanihal() {
        return candidate_post_of_nanihal;
    }

    public void setCandidate_post_of_nanihal(String candidate_post_of_nanihal) {
        this.candidate_post_of_nanihal = candidate_post_of_nanihal;
    }

    public String getCandidate_teh_of_nanihal() {
        return candidate_teh_of_nanihal;
    }

    public void setCandidate_teh_of_nanihal(String candidate_teh_of_nanihal) {
        this.candidate_teh_of_nanihal = candidate_teh_of_nanihal;
    }

    public String getCandidate_polstation_of_nanihal() {
        return candidate_polstation_of_nanihal;
    }

    public void setCandidate_polstation_of_nanihal(String candidate_polstation_of_nanihal) {
        this.candidate_polstation_of_nanihal = candidate_polstation_of_nanihal;
    }

    public String getCandidate_dist_of_nanihal() {
        return candidate_dist_of_nanihal;
    }

    public void setCandidate_dist_of_nanihal(String candidate_dist_of_nanihal) {
        this.candidate_dist_of_nanihal = candidate_dist_of_nanihal;
    }

    public String getCandidate_state_of_nanihal() {
        return candidate_state_of_nanihal;
    }

    public void setCandidate_state_of_nanihal(String candidate_state_of_nanihal) {
        this.candidate_state_of_nanihal = candidate_state_of_nanihal;
    }

    public String getCandidate_country_of_nanihal() {
        return candidate_country_of_nanihal;
    }

    public void setCandidate_country_of_nanihal(String candidate_country_of_nanihal) {
        this.candidate_country_of_nanihal = candidate_country_of_nanihal;
    }

    public String getCandidate_pin_of_nanihal() {
        return candidate_pin_of_nanihal;
    }

    public void setCandidate_pin_of_nanihal(String candidate_pin_of_nanihal) {
        this.candidate_pin_of_nanihal = candidate_pin_of_nanihal;
    }

    public String getCandidate_name_of_dadera() {
        return candidate_name_of_dadera;
    }

    public void setCandidate_name_of_dadera(String candidate_name_of_dadera) {
        this.candidate_name_of_dadera = candidate_name_of_dadera;
    }

    public String getCandidate_cast_of_dadera() {
        return candidate_cast_of_dadera;
    }

    public void setCandidate_cast_of_dadera(String candidate_cast_of_dadera) {
        this.candidate_cast_of_dadera = candidate_cast_of_dadera;
    }

    public String getCandidate_gotra_of_dadera() {
        return candidate_gotra_of_dadera;
    }

    public void setCandidate_gotra_of_dadera(String candidate_gotra_of_dadera) {
        this.candidate_gotra_of_dadera = candidate_gotra_of_dadera;
    }

    public String getCandidate_address_of_dadera() {
        return candidate_address_of_dadera;
    }

    public void setCandidate_address_of_dadera(String candidate_address_of_dadera) {
        this.candidate_address_of_dadera = candidate_address_of_dadera;
    }

    public String getCandidate_post_of_dadera() {
        return candidate_post_of_dadera;
    }

    public void setCandidate_post_of_dadera(String candidate_post_of_dadera) {
        this.candidate_post_of_dadera = candidate_post_of_dadera;
    }

    public String getCandidate_teh_of_dadera() {
        return candidate_teh_of_dadera;
    }

    public void setCandidate_teh_of_dadera(String candidate_teh_of_dadera) {
        this.candidate_teh_of_dadera = candidate_teh_of_dadera;
    }

    public String getCandidate_polstation_of_dadera() {
        return candidate_polstation_of_dadera;
    }

    public void setCandidate_polstation_of_dadera(String candidate_polstation_of_dadera) {
        this.candidate_polstation_of_dadera = candidate_polstation_of_dadera;
    }

    public String getCandidate_dist_of_dadera() {
        return candidate_dist_of_dadera;
    }

    public void setCandidate_dist_of_dadera(String candidate_dist_of_dadera) {
        this.candidate_dist_of_dadera = candidate_dist_of_dadera;
    }

    public String getCandidate_state_of_dadera() {
        return candidate_state_of_dadera;
    }

    public void setCandidate_state_of_dadera(String candidate_state_of_dadera) {
        this.candidate_state_of_dadera = candidate_state_of_dadera;
    }

    public String getCandidate_country_of_dadera() {
        return candidate_country_of_dadera;
    }

    public void setCandidate_country_of_dadera(String candidate_country_of_dadera) {
        this.candidate_country_of_dadera = candidate_country_of_dadera;
    }

    public String getCandidate_pin_of_dadera() {
        return candidate_pin_of_dadera;
    }

    public void setCandidate_pin_of_dadera(String candidate_pin_of_dadera) {
        this.candidate_pin_of_dadera = candidate_pin_of_dadera;
    }

    public String getTenth_board() {
        return tenth_board;
    }

    public void setTenth_board(String tenth_board) {
        this.tenth_board = tenth_board;
    }

    public String getTenth_per() {
        return tenth_per;
    }

    public void setTenth_per(String tenth_per) {
        this.tenth_per = tenth_per;
    }

    public String getTwelth_board() {
        return twelth_board;
    }

    public void setTwelth_board(String twelth_board) {
        this.twelth_board = twelth_board;
    }

    public String getTenth_sub() {
        return tenth_sub;
    }

    public void setTenth_sub(String tenth_sub) {
        this.tenth_sub = tenth_sub;
    }

    public String getTwelth_per() {
        return twelth_per;
    }

    public void setTwelth_per(String twelth_per) {
        this.twelth_per = twelth_per;
    }

    public String getGradu_uni() {
        return gradu_uni;
    }

    public void setGradu_uni(String gradu_uni) {
        this.gradu_uni = gradu_uni;
    }

    public String getGradu_sub() {
        return gradu_sub;
    }

    public void setGradu_sub(String gradu_sub) {
        this.gradu_sub = gradu_sub;
    }

    public String getGradu_per() {
        return gradu_per;
    }

    public void setGradu_per(String gradu_per) {
        this.gradu_per = gradu_per;
    }

    public String getPg_uni() {
        return pg_uni;
    }

    public void setPg_uni(String pg_uni) {
        this.pg_uni = pg_uni;
    }

    public String getPg_sub() {
        return pg_sub;
    }

    public void setPg_sub(String pg_sub) {
        this.pg_sub = pg_sub;
    }

    public String getPg_per() {
        return pg_per;
    }

    public void setPg_per(String pg_per) {
        this.pg_per = pg_per;
    }

    public String getOther_edu() {
        return other_edu;
    }

    public void setOther_edu(String other_edu) {
        this.other_edu = other_edu;
    }

    public String getOther_edu_per() {
        return other_edu_per;
    }

    public void setOther_edu_per(String other_edu_per) {
        this.other_edu_per = other_edu_per;
    }

    public String getOther_edu_sub() {
        return other_edu_sub;
    }

    public void setOther_edu_sub(String other_edu_sub) {
        this.other_edu_sub = other_edu_sub;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob_department() {
        return job_department;
    }

    public void setJob_department(String job_department) {
        this.job_department = job_department;
    }

    public String getJob_from() {
        return job_from;
    }

    public void setJob_from(String job_from) {
        this.job_from = job_from;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDahejoth_descrip() {
        return dahejoth_descrip;
    }

    public void setDahejoth_descrip(String dahejoth_descrip) {
        this.dahejoth_descrip = dahejoth_descrip;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getSister() {
        return sister;
    }

    public void setSister(String sister) {
        this.sister = sister;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getDaughter() {
        return daughter;
    }

    public void setDaughter(String daughter) {
        this.daughter = daughter;
    }

    public String getMarriedchild() {
        return marriedchild;
    }

    public void setMarriedchild(String marriedchild) {
        this.marriedchild = marriedchild;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGender_self() {
        return gender_self;
    }

    public void setGender_self(String gender_self) {
        this.gender_self = gender_self;
    }

    public String getRefrencename() {
        return refrencename;
    }

    public void setRefrencename(String refrencename) {
        this.refrencename = refrencename;
    }

    public String getRefrencenamE_MOB() {
        return refrencenamE_MOB;
    }

    public void setRefrencenamE_MOB(String refrencenamE_MOB) {
        this.refrencenamE_MOB = refrencenamE_MOB;
    }

    public Boolean getDahejoth() {
        return dahejoth;
    }

    public void setDahejoth(Boolean dahejoth) {
        this.dahejoth = dahejoth;
    }

    public int getCandidate_son() {
        return candidate_son;
    }

    public void setCandidate_son(int candidate_son) {
        this.candidate_son = candidate_son;
    }

    public int getCandidate_daughter() {
        return candidate_daughter;
    }

    public void setCandidate_daughter(int candidate_daughter) {
        this.candidate_daughter = candidate_daughter;
    }
}
