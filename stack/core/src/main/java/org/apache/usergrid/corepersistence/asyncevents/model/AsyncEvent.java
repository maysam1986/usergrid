/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.usergrid.corepersistence.asyncevents.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.usergrid.persistence.collection.serialization.impl.migration.EntityIdScope;
import org.apache.usergrid.persistence.core.scope.ApplicationScope;
import org.apache.usergrid.persistence.graph.Edge;
import org.apache.usergrid.persistence.model.entity.Id;

import java.io.Serializable;

/**
 * Created by Jeff West on 5/25/15.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AsyncEvent implements Serializable {

    @JsonProperty
    protected EventType eventType;

    @JsonProperty
    protected EntityIdScope entityIdScope;

    @JsonProperty
    protected ApplicationScope applicationScope;

    @JsonProperty
    protected Id entityId;

    @JsonProperty
    protected Edge edge;

    @JsonProperty
    protected long creationTime;

    /**
     * required for jackson, do not delete
     */

    protected AsyncEvent() {
    }

    public AsyncEvent(final EventType eventType) {

        this.eventType = eventType;
        this.creationTime = System.currentTimeMillis();
    }

    public AsyncEvent(final EventType eventType,
                      final EntityIdScope entityIdScope) {

        this.eventType = eventType;
        this.entityIdScope = entityIdScope;
        this.creationTime = System.currentTimeMillis();
    }

    public AsyncEvent(EventType eventType, ApplicationScope applicationScope) {
        this.eventType = eventType;
        this.applicationScope = applicationScope;
        this.creationTime = System.currentTimeMillis();
    }

    public AsyncEvent(EventType eventType, ApplicationScope applicationScope, Edge edge) {
        this.eventType = eventType;
        this.applicationScope = applicationScope;
        this.edge = edge;
        this.creationTime = System.currentTimeMillis();
    }

    public AsyncEvent(EventType eventType, ApplicationScope applicationScope, Id entityId, Edge edge) {
        this.eventType = eventType;
        this.applicationScope = applicationScope;
        this.edge = edge;
        this.entityId = entityId;
        this.creationTime = System.currentTimeMillis();
    }

    @JsonSerialize()
    public final Id getEntityId() {
        return entityId;
    }

    protected void setEntityId(Id entityId) {
        this.entityId = entityId;
    }

    @JsonSerialize()
    public final EventType getEventType() {
        return eventType;
    }

    protected void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @JsonSerialize()
    public EntityIdScope getEntityIdScope() {
        return entityIdScope;
    }

    protected void setEntityIdScope(EntityIdScope entityIdScope) {
        this.entityIdScope = entityIdScope;
    }

    @JsonSerialize()
    public ApplicationScope getApplicationScope() {
        return applicationScope;
    }

    protected void setApplicationScope(ApplicationScope applicationScope) {
        this.applicationScope = applicationScope;
    }

    @JsonSerialize()
    public Edge getEdge() {
        return edge;
    }

    @JsonSerialize()
    public long getCreationTime() {  return creationTime; }

    protected void setEdge(Edge edge) {
        this.edge = edge;
    }

    public enum EventType {
        EDGE_DELETE,
        EDGE_INDEX,
        ENTITY_DELETE,
        ENTITY_INDEX,
        APPLICATION_INDEX,
        MANAGEMENT_INDEX;
        ;


        public String asString() {
            return toString();
        }
    }
}
