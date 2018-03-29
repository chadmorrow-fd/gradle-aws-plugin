/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.classmethod.aws.gradle.cloudformation;

import java.io.IOException;

import lombok.Getter;
import lombok.Setter;

import org.gradle.api.GradleException;
import org.gradle.api.tasks.TaskAction;

import jp.classmethod.aws.gradle.common.BaseAwsTask;

public class AmazonCloudFormationValidateTemplateUrlTask extends BaseAwsTask {
	
	@Getter
	@Setter
	private String cfnTemplateUrl;
	
	
	public AmazonCloudFormationValidateTemplateUrlTask() {
		super("AWS", "Validate template URL.");
	}
	
	@TaskAction
	public void validateTemplateUrl() throws InterruptedException, IOException {
		// to enable conventionMappings feature
		String cfnTemplateUrl = getCfnTemplateUrl();
		AmazonCloudFormationPluginExtension ext = getPluginExtension(AmazonCloudFormationPluginExtension.class);
		
		if (ext.isValidTemplateUrl(cfnTemplateUrl) == false) {
			throw new GradleException("cloudFormation template has invalid format");
		}
	}
}
