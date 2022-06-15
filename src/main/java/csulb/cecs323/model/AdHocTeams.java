package csulb.cecs323.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class AdHocTeams extends csulb.cecs323.model.AuthoringEntities {
    @OneToMany (mappedBy = "teams",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    // List of ad hoc team members
    private ArrayList<csulb.cecs323.model.AdHocTeamMembers> teamMembers;

    // Default constructor
    public AdHocTeams() { }

    // Constructor that creates an ad hoc team with a name and email
    public AdHocTeams(String name, String email) {
        super(name, email, "Ad Hoc Team");
    }

    /**
     * Adds an ad hoc team member to the list of members
     * @param teamMember The team member being added
     */
    public void addTeamMembers(csulb.cecs323.model.AdHocTeamMembers teamMember) {
        teamMembers.add(teamMember);
        teamMember.setAdHocTeams(this);
    }

    /**
     * If they exist, the team member is removed from the list of members
     * @param teamMember The member being removed
     */
    public void removeTeamMembers(csulb.cecs323.model.AdHocTeamMembers teamMember) {
        if (this.teamMembers != null) {
            teamMembers.remove(teamMember);
            teamMember.setAdHocTeams(null);
        }
    }

    public ArrayList<csulb.cecs323.model.AdHocTeamMembers> getTeamMembers() { return teamMembers; }

    public void setTeamMembers(ArrayList<csulb.cecs323.model.AdHocTeamMembers> teamMembers) { this.teamMembers = teamMembers; }
}