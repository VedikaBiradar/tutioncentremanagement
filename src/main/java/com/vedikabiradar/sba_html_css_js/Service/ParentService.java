//package com.vedikabiradar.sba_html_css_js.Service;
//
//import com.vedikabiradar.sba_html_css_js.Entity.Parent;
//import com.vedikabiradar.sba_html_css_js.Repository.ParentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ParentService {
//
//    @Autowired
//    private ParentRepository parentRepository;
//
//    public List<Parent> getAllParents() {
//        return parentRepository.findAll();
//    }
//
//    public Parent saveParent(Parent parent) {
//        return parentRepository.save(parent);
//    }
//
//    public Optional<Parent> getParentById(Long parentId) {
//        return parentRepository.findById(parentId);
//    }
//
//    // Additional method for deleting a parent by id
//    public void deleteParentById(Long parentId) {
//        parentRepository.deleteById(parentId);
//    }
//}