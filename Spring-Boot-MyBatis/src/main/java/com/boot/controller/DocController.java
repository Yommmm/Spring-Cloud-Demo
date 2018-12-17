package com.boot.controller;

import java.net.URL;
import java.nio.file.Paths;

import org.asciidoctor.cli.AsciidoctorInvoker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;

@RestController
@RequestMapping("/boot/v2/docs")
public class DocController {
	
	@GetMapping("/generateAscii")
	public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
 
        Swagger2MarkupConverter.from(new URL("http://localhost:8060/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./src/main/resources/docs/asciidoc/generated"));
        
    }
    
    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     * @throws Exception
     */
	@GetMapping("/generateAsciiToFile")
    public void generateAsciiDocsToFile() throws Exception {
        //    输出Ascii到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
 
        Swagger2MarkupConverter.from(new URL("http://localhost:8060/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("./src/main/resources/docs/asciidoc/generated/all"));
        
        AsciidoctorInvoker.main(new String[]{"-b", "html5", "-d", "book", "./src/main/resources/docs/asciidoc/generated/all.adoc"});
        
        AsciidoctorInvoker.main(new String[]{"./src/main/resources/docs/asciidoc/generated/all.adoc"});
        
    }
	
	/**
     * 生成Markdown格式文档
     * @throws Exception
     */
	@GetMapping("/generateMarkdown")
    public void generateMarkdownDocs() throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
                .withOutputLanguage(Language.ZH)
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();
 
        Swagger2MarkupConverter.from(new URL("http://localhost:8060/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("./src/main/resources/docs/markdown/generated"));
    }
 
	/**
	 * 生成Markdown格式文档,并汇总成一个文件
	 * @throws Exception
	 */
	@GetMapping("/generateMarkdownToFile")
	public void generateMarkdownDocsToFile() throws Exception {
		// 输出Markdown到单文件
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.MARKDOWN)
				.withOutputLanguage(Language.ZH)
				.withPathsGroupedBy(GroupBy.TAGS)
				.withGeneratedExamples()
				.withoutInlineSchema().build();

		Swagger2MarkupConverter.from(new URL("http://localhost:8060/v2/api-docs"))
				.withConfig(config).build()
				.toFile(Paths.get("./src/main/resources/docs/markdown/generated/all"));
		
	}
	
}
