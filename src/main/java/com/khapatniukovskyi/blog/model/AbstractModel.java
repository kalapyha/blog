package com.khapatniukovskyi.blog.model;
/** @author devstudy
* @see http://devstudy.net
* @version 1.0
*/
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class AbstractModel {

	@Override
	public String toString() {
		// Each object converts to a String
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}

