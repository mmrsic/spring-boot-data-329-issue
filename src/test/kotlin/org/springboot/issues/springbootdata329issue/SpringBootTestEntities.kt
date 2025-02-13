package org.springboot.issues.springbootdata329issue

import jakarta.persistence.*

@Entity(name = "ParentEntity")
@Table(name = "PARENT_TABLE")
open class SpringBootTestParentEntity() {

    private var parentId: String? = null
    private var children: MutableList<SpringBootTestChildEntity> = ArrayList()

    constructor(parentId: String, children: MutableList<SpringBootTestChildEntity>) : this() {
        this.parentId = parentId
        this.children = children
    }

    @Id
    open fun getParentId() = parentId
    open fun setParentId(id: String) {
        parentId = id
    }

    @ElementCollection(targetClass = SpringBootTestChildEntity::class, fetch = FetchType.EAGER)
    @CollectionTable(
        name = "CHILD_TABLE",
        joinColumns = [JoinColumn(name = "parentId", referencedColumnName = "parentId")],
    )
    open fun getChildren() = children

    open fun setChildren(newChildren: MutableList<SpringBootTestChildEntity>) {
        children = newChildren
    }
}

@Embeddable
@Table(name = "CHILD_TABLE")
open class SpringBootTestChildEntity() {

    constructor(id: String) : this() {
        childId = id
    }

    private var childId: String = ""
    private var child: Boolean = true
    private var fromOuterSpace: Boolean = false

    open fun getChildId() = childId

    open fun setChildId(newId: String) {
        childId = newId
    }


    open fun getChild() = child
    open fun setChild(newValue: Boolean) {
        child = newValue
    }


    open fun getFromOuterSpace() = fromOuterSpace

    open fun setFromOuterSpace(newValue: Boolean) {
        this.fromOuterSpace = newValue
    }

}
