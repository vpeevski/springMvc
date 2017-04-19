package discoverita.example.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		File file = new File(System.getProperty("user.home") + File.separator + "uploads");
		if (!file.exists()) {
			file.mkdirs();
		}
		registration.setMultipartConfig(new MultipartConfigElement(file.getAbsolutePath(), 2097152, 4194304, 0));
	}
	

}
