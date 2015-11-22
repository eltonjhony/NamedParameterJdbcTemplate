package br.com.jdbc.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class StoryDAOImpl implements IfStoryDAO {

	/** Template class to access JDBC operations **/
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * @param dataSource The {@link DataSource} used to communicate with the database. 
     */
    @Autowired
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public static final String SQL_TEST_IN_CLAUSE = "SELECT * FROM POKER_STORY_TBL WHERE "
			+ DBFieldCoreConstants.COMPONENT
			+ " IN (:components) ";
    
	@Override
	public List<Story> findStories(List<String> components) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("components", components);
		return jdbcTemplate.query(SQL_TEST_IN_CLAUSE, parameters, STORY_ROW_MAPPER);
	}
	
	/**
     * {@link RowMapper} for {@link Story}.
     * 
     * @see RowMapper
     */
    private RowMapper<Story> STORY_ROW_MAPPER = new RowMapper<Story>() {
    	@Override
    	public Story mapRow(ResultSet rs, int rowNum)
    			throws SQLException {
    		
    		Story story = new Story();
    		story.setUniqueKey(rs.getInt(DBFieldCoreConstants.UNIQUE_KEY));
    		story.setComponent(rs.getString(DBFieldCoreConstants.COMPONENT));
    		story.setCurrentProject(rs.getString(DBFieldCoreConstants.CURRENT_PROJECT));
    		story.setParticipants(rs.getInt(DBFieldCoreConstants.PARTICIPANTS));
    		story.setSprint(rs.getString(DBFieldCoreConstants.SPRINT));
    		story.setStoryName(rs.getString(DBFieldCoreConstants.STORY_NAME));
    		story.setRegDate(rs.getDate(DBFieldCoreConstants.REG_DATE));
    		story.setEstimate(rs.getInt(DBFieldCoreConstants.ESTIMATE));
            
    		return story;
    	}
    };

}
