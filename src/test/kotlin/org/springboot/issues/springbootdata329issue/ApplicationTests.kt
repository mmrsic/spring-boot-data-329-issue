package org.springboot.issues.springbootdata329issue

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class ApplicationTests(@Autowired val repo: SpringBootTestRepository) {

    /**
     * This test case works when using Spring Boot 3.2.8 but fails when using version 3.2.9.
     */
    @Test
    fun testInvokedMethodIsNotAPropertyAccessorSpringBoot329() {
        val childId = "childId"
        val child = SpringBootTestChildEntity(childId)
        val parent = SpringBootTestParentEntity(parentId = "parentId", children = mutableListOf(child))
        repo.save(parent)

        // act
        val result = repo.findByChildrenChildId(childId)

        // assert
        assert(result.isNotEmpty())
        result.forEach {
            val children = it.children
            children.childId // This fails with IllegalStateException for Spring Boot 3.2.9 but works in 3.3.8
            children.isChild
            children.fromOuterSpace // This fails in Spring Boot 3.3.8 (because of missing "is" prefix) but works in 3.2.8
        }
    }
}
