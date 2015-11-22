package br.com.jdbc.example;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.core.style.ToStringCreator;
/**
 * Created by elton on 17/07/15.
 */
@XmlRootElement
public class Story implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer uniqueKey;
    private String component;
    private Integer participants;
    private Integer estimate;
    private String storyName;
    private String sprint;
    private String currentProject;
    private Date regDate;

    public Integer getUniqueKey() {
        return uniqueKey != null ? uniqueKey : 0;
    }

    public void setUniqueKey(Integer uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    
    public Integer getEstimate() {
		return estimate;
	}
    
    public void setEstimate(Integer estimate) {
		this.estimate = estimate;
	}

	public String toString() {
		return new ToStringCreator(this).append("uniqueKey", uniqueKey)
				.append("component", component)
				.append("participants", participants)
				.append("estimate", estimate).append("storyName", storyName)
				.append("sprint", sprint)
				.append("currentProject", currentProject)
				.append("regDate", regDate).toString();
    }
    
}
