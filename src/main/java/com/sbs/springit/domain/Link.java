package com.sbs.springit.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import com.sbs.springit.service.BeanUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Link extends Auditable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	@NotEmpty(message = "Please enter a title.")
	private String title;
	
	@NonNull
	@NotEmpty(message = "Please enter a url.")
	@URL(message = "Please enter a valid URL.")
	private String url;
	
	@OneToMany(mappedBy = "link")
	private List<Comment> comments = new ArrayList<>();	
	
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public String getDomainName() throws URISyntaxException {
	    URI uri = new URI(this.url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public String getPrettyTime() {
	    PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
	    return pt.format(convertToDateViaInstant(getCreationDate()));
	}

	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
	    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}

	public Link(Long id, @NonNull String title, @NonNull String url, List<Comment> comments) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.comments = comments;
	}
}
