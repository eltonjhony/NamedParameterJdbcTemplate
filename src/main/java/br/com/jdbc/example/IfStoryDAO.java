package br.com.jdbc.example;

import java.util.List;

public interface IfStoryDAO {

	List<Story> findStories(List<String> components);
}
