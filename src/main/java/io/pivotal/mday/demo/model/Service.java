package io.pivotal.mday.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "credentials", "syslog_drain_url", "volume_mounts", "label", "provider", "plan", "name", "tags" })
public class Service {

	@JsonProperty("credentials")
	private Credentials credentials;
	@JsonProperty("syslog_drain_url")
	private Object syslogDrainUrl;
	@JsonProperty("volume_mounts")
	private List<Object> volumeMounts = null;
	@JsonProperty("label")
	private String label;
	@JsonProperty("provider")
	private Object provider;
	@JsonProperty("plan")
	private String plan;
	@JsonProperty("name")
	private String name;
	@JsonProperty("tags")
	private List<String> tags = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("credentials")
	public Credentials getCredentials() {
		return credentials;
	}

	@JsonProperty("credentials")
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	@JsonProperty("syslog_drain_url")
	public Object getSyslogDrainUrl() {
		return syslogDrainUrl;
	}

	@JsonProperty("syslog_drain_url")
	public void setSyslogDrainUrl(Object syslogDrainUrl) {
		this.syslogDrainUrl = syslogDrainUrl;
	}

	@JsonProperty("volume_mounts")
	public List<Object> getVolumeMounts() {
		return volumeMounts;
	}

	@JsonProperty("volume_mounts")
	public void setVolumeMounts(List<Object> volumeMounts) {
		this.volumeMounts = volumeMounts;
	}

	@JsonProperty("label")
	public String getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(String label) {
		this.label = label;
	}

	@JsonProperty("provider")
	public Object getProvider() {
		return provider;
	}

	@JsonProperty("provider")
	public void setProvider(Object provider) {
		this.provider = provider;
	}

	@JsonProperty("plan")
	public String getPlan() {
		return plan;
	}

	@JsonProperty("plan")
	public void setPlan(String plan) {
		this.plan = plan;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("tags")
	public List<String> getTags() {
		return tags;
	}

	@JsonProperty("tags")
	public void setTags(List<String> tags) {
		this.tags = tags;
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