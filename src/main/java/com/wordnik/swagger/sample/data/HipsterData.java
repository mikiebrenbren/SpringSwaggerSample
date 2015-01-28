/**
 *  Copyright 2014 Reverb Technologies, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wordnik.swagger.sample.data;

import com.wordnik.swagger.sample.model.*;

import java.util.List;
import java.util.ArrayList;
//
public class HipsterData {
  static List<Hipster> hipsters = new ArrayList<Hipster>();
  static List<Category> categories = new ArrayList<Category>();

  static {
    categories.add(createCategory(1, "Dogs"));
    categories.add(createCategory(2, "Cats"));
    categories.add(createCategory(3, "Rabbits"));
    categories.add(createCategory(4, "Lions"));

    hipsters.add(createHipster(1, categories.get(1), "Cat 1", new String[]{
            "url1", "url2"}, new String[]{"tag1", "tag2"}, "available", "black"));
    hipsters.add(createHipster(2, categories.get(1), "Cat 2", new String[]{
            "url1", "url2"}, new String[]{"tag2", "tag3"}, "available", "black"));
    hipsters.add(createHipster(3, categories.get(1), "Cat 3", new String[]{
            "url1", "url2"}, new String[]{"tag3", "tag4"}, "pending", "black"));

    hipsters.add(createHipster(4, categories.get(0), "Dog 1", new String[]{
            "url1", "url2"}, new String[]{"tag1", "tag2"}, "available", "black"));
    hipsters.add(createHipster(5, categories.get(0), "Dog 2", new String[]{
            "url1", "url2"}, new String[]{"tag2", "tag3"}, "sold", "black"));
    hipsters.add(createHipster(6, categories.get(0), "Dog 3", new String[]{
            "url1", "url2"}, new String[]{"tag3", "tag4"}, "pending", "black"));

    hipsters.add(createHipster(7, categories.get(3), "Lion 1", new String[]{
            "url1", "url2"}, new String[]{"tag1", "tag2"}, "available", "black"));
    hipsters.add(createHipster(8, categories.get(3), "Lion 2", new String[]{
            "url1", "url2"}, new String[]{"tag2", "tag3"}, "available", "black"));
    hipsters.add(createHipster(9, categories.get(3), "Lion 3", new String[]{
            "url1", "url2"}, new String[]{"tag3", "tag4"}, "available", "black"));

    hipsters.add(createHipster(10, categories.get(2), "Rabbit 1", new String[]{
            "url1", "url2"}, new String[]{"tag3", "tag4"}, "available", "black"));
  }

  public Hipster getHipsterbyId(long hipsterId) {
    for (Hipster hipster : hipsters) {
      if (hipster.getId() == hipsterId) {
        return hipster;
      }
    }
    return null;
  }

  public List<Hipster> findHipsterByStatus(String status) {
    String[] statues = status.split(",");
    List<Hipster> result = new java.util.ArrayList<Hipster>();
    for (Hipster hipster : hipsters) {
      for (String s : statues) {
        if (s.equals(hipster.getStatus())) {
          result.add(hipster);
        }
      }
    }
    return result;
  }

  public List<Hipster> findHipsterByTags(String tags) {
    String[] tagList = tags.split(",");
    List<Hipster> result = new java.util.ArrayList<Hipster>();
    for (Hipster hipster : hipsters) {
      if (null != hipster.getTags()) {
        for (Tag tag : hipster.getTags()) {
          for (String tagListString : tagList) {
            if (tagListString.equals(tag.getName()))
              result.add(hipster);
          }
        }
      }
    }
    return result;
  }

  public void addHipster(Hipster hipster) {
    if (hipsters.size() > 0) {
      for (int i = hipsters.size() - 1; i >= 0; i--) {
        if (hipsters.get(i).getId() == hipster.getId()) {
          hipsters.remove(i);
        }
      }
    }
    hipsters.add(hipster);
  }

  static Hipster createHipster(long id, Category cat, String name, String[] urls,
                               String[] tags, String status,String color) {
    Hipster hipster = new Hipster();
    hipster.setId(id);
    hipster.setCategory(cat);
    hipster.setName(name);
    hipster.setMoustache(color);
    if (null != urls) {
      List<String> urlObjs = new ArrayList<String>();
      for (String urlString : urls) {
        urlObjs.add(urlString);
      }
      hipster.setPhotoUrls(urlObjs);
    }
    List<Tag> tagObjs = new java.util.ArrayList<Tag>();
    int i = 0;
    if (null != tags) {
      for (String tagString : tags) {
        i = i + 1;
        Tag tag = new Tag();
        tag.setId(i);
        tag.setName(tagString);
        tagObjs.add(tag);
      }
    }
    hipster.setTags(tagObjs);
    hipster.setStatus(status);
    return hipster;
  }

  static Category createCategory(long id, String name) {
    Category category = new Category();
    category.setId(id);
    category.setName(name);
    return category;
  }


}