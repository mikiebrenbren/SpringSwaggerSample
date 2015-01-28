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

package com.wordnik.swagger.sample.bean;

import com.wordnik.swagger.sample.data.HipsterData;
import com.wordnik.swagger.sample.model.Hipster;
import com.wordnik.swagger.sample.exception.NotFoundException;
import com.wordnik.swagger.sample.resource.HipsterResource;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
//
@Component
public class HipsterResourceBean implements HipsterResource {
    static HipsterData hipsterData = new HipsterData();
    static JavaRestResourceUtil ru = new JavaRestResourceUtil();

    @Override
    public Hipster getHipsterById(String hipsterId) throws NotFoundException {
        Hipster hipster = hipsterData.getHipsterbyId(ru.getLong(0, 100000, 0, hipsterId));
        if (null != hipster) {
            return hipster;
        } else {
            throw new NotFoundException(404, "Hipster not found");
        }
    }

    @Override
    public Response addHipster(Hipster hipster) {
        hipsterData.addHipster(hipster);
        return Response.ok().entity("SUCCESS").build();
    }

    @Override
    public Response updateHipster(Hipster hipster) {
        hipsterData.addHipster(hipster);
        return Response.ok().entity("SUCCESS").build();
    }

    @Override
    public Response findHipstersByStatus(String status) {
        return Response.ok(hipsterData.findHipsterByStatus(status)).build();
    }

    @Override
    @Deprecated
    public Response findHipstersByTags(String tags) {
        return Response.ok(hipsterData.findHipsterByTags(tags)).build();
    }
}
