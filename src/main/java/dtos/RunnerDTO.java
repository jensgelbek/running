/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Runner;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class RunnerDTO {
    private Long id;
    private String name;
    private String gender;
    private Date bDay;

    public RunnerDTO(String name, String gender, Date bDay) {
        this.name = name;
        this.gender = gender;
        this.bDay = bDay;
    }

    public RunnerDTO(Runner r) {
        this.id=r.getId();
        this.name=r.getName();
        this.gender=r.getGender();
        this.bDay=r.getbDay();
    }

         public static List<RunnerDTO> getRunnerList(List<Runner> rs){
        return rs.stream()
            .map(r -> new RunnerDTO(r))
            .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.gender);
        hash = 29 * hash + Objects.hashCode(this.bDay);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RunnerDTO other = (RunnerDTO) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bDay, other.bDay)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RunnerDTO{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", bDay=" + bDay + '}';
    }

    
    
}
