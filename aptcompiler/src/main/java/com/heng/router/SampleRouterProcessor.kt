package com.heng.router

import com.google.auto.service.AutoService
import com.heng.router.annotations.Route
import com.heng.router.annotations.Routes
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Filer
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.annotation.processing.SupportedSourceVersion
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

/**
 * @author zhangheng
 * @email 932805400@qq.com
 * @describe 路由注解处理
 * @since 2020/10/21
 */
@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
class SampleRouterProcessor : AbstractProcessor() {

    private lateinit var mFiler: Filer
    private lateinit var mElements: Elements

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        mFiler = processingEnv.filer
        mElements = processingEnv.elementUtils
    }

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latestSupported()

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return hashSetOf<String>().apply {
            add(Routes::class.java.canonicalName)
            add(Route::class.java.canonicalName)
        }
    }

    override fun process(
        annotations: MutableSet<out TypeElement>?,
        roundEnv: RoundEnvironment?
    ): Boolean {
        TODO("Not yet implemented")
    }
}
