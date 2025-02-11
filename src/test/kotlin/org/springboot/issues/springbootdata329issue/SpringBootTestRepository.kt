package org.springboot.issues.springbootdata329issue

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SpringBootTestRepository : JpaRepository<SpringBootTestParentEntity, String> {

    fun findByChildrenChildId(wantedChildId: String): List<SpringBootTestParentInterface>
}
