package org.springboot.issues.springbootdata329issue

interface SpringBootTestParentInterface {

    val parentId: String
    val children: SpringBootTestChildInterface

}

interface SpringBootTestChildInterface {

    val childId: String
}
