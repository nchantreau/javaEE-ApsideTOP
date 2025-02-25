package fr.apside.formation.jaxb.model.club;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Association sportive
 */
@XmlRootElement(name = "association_sportive")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sport extends Association {

    /**
     * Nom du sport
     */
    @XmlAttribute
    private String sport;

    /**
     * Type de sport
     */
    @XmlAttribute(name = "sport_type")
    private SportType sportType;

    /**
     * Nombre d'équipe
     */
    @XmlAttribute(name = "nombre_equipe")
    private Integer teamCount;

    public Sport() {
    }

    public Sport(Long id, String name, String sport, SportType sportType, Integer teamCount) {
        super(id, name);
        this.sport = sport;
        this.sportType = sportType;
        this.teamCount = teamCount;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public Integer getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(Integer teamCount) {
        this.teamCount = teamCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sport)) return false;
        if (!super.equals(o)) return false;
        Sport sport1 = (Sport) o;
        return Objects.equals(getSport(), sport1.getSport()) &&
                Objects.equals(getSportType(), sport1.getSportType()) &&
                Objects.equals(getTeamCount(), sport1.getTeamCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSportType());
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportType=" + sportType +
                ", sport='" + sport + '\'' +
                "} " + super.toString();
    }
}
