package io.pivotal.mday.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "jdbcUrl", "uri", "name", "hostname", "port", "username", "password" })
public class Credentials {

	@JsonProperty("jdbcUrl")
	private String jdbcUrl;
	@JsonProperty("uri")
	private String uri;
	@JsonProperty("name")
	private String name;
	@JsonProperty("hostname")
	private String hostname;
	@JsonProperty("port")
	private String port;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("jdbcUrl")
	public String getJdbcUrl() {
		return jdbcUrl;
	}

	@JsonProperty("jdbcUrl")
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	@JsonProperty("uri")
	public String getUri() {
		return uri;
	}

	@JsonProperty("uri")
	public void setUri(String uri) {
		this.uri = uri;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("hostname")
	public String getHostname() {
		return hostname;
	}

	@JsonProperty("hostname")
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	@JsonProperty("port")
	public String getPort() {
		return port;
	}

	@JsonProperty("port")
	public void setPort(String port) {
		this.port = port;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}