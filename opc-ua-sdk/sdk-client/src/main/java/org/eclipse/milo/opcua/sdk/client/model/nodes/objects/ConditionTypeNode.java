/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.client.model.nodes.objects;

import java.util.concurrent.CompletableFuture;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.model.nodes.variables.ConditionVariableTypeNode;
import org.eclipse.milo.opcua.sdk.client.model.nodes.variables.PropertyTypeNode;
import org.eclipse.milo.opcua.sdk.client.model.nodes.variables.TwoStateVariableTypeNode;
import org.eclipse.milo.opcua.sdk.client.model.types.objects.ConditionType;
import org.eclipse.milo.opcua.sdk.client.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;

public class ConditionTypeNode extends BaseEventTypeNode implements ConditionType {
    public ConditionTypeNode(OpcUaClient client, NodeId nodeId) {
        super(client, nodeId);
    }

    public CompletableFuture<PropertyTypeNode> getConditionClassIdNode() {
        return getPropertyNode(ConditionType.CONDITION_CLASS_ID);
    }

    public CompletableFuture<NodeId> getConditionClassId() {
        return getProperty(ConditionType.CONDITION_CLASS_ID);
    }

    public CompletableFuture<StatusCode> setConditionClassId(NodeId value) {
        return setProperty(ConditionType.CONDITION_CLASS_ID, value);
    }

    public CompletableFuture<PropertyTypeNode> getConditionClassNameNode() {
        return getPropertyNode(ConditionType.CONDITION_CLASS_NAME);
    }

    public CompletableFuture<LocalizedText> getConditionClassName() {
        return getProperty(ConditionType.CONDITION_CLASS_NAME);
    }

    public CompletableFuture<StatusCode> setConditionClassName(LocalizedText value) {
        return setProperty(ConditionType.CONDITION_CLASS_NAME, value);
    }

    public CompletableFuture<PropertyTypeNode> getConditionNameNode() {
        return getPropertyNode(ConditionType.CONDITION_NAME);
    }

    public CompletableFuture<String> getConditionName() {
        return getProperty(ConditionType.CONDITION_NAME);
    }

    public CompletableFuture<StatusCode> setConditionName(String value) {
        return setProperty(ConditionType.CONDITION_NAME, value);
    }

    public CompletableFuture<PropertyTypeNode> getBranchIdNode() {
        return getPropertyNode(ConditionType.BRANCH_ID);
    }

    public CompletableFuture<NodeId> getBranchId() {
        return getProperty(ConditionType.BRANCH_ID);
    }

    public CompletableFuture<StatusCode> setBranchId(NodeId value) {
        return setProperty(ConditionType.BRANCH_ID, value);
    }

    public CompletableFuture<PropertyTypeNode> getRetainNode() {
        return getPropertyNode(ConditionType.RETAIN);
    }

    public CompletableFuture<Boolean> getRetain() {
        return getProperty(ConditionType.RETAIN);
    }

    public CompletableFuture<StatusCode> setRetain(Boolean value) {
        return setProperty(ConditionType.RETAIN, value);
    }

    public CompletableFuture<PropertyTypeNode> getClientUserIdNode() {
        return getPropertyNode(ConditionType.CLIENT_USER_ID);
    }

    public CompletableFuture<String> getClientUserId() {
        return getProperty(ConditionType.CLIENT_USER_ID);
    }

    public CompletableFuture<StatusCode> setClientUserId(String value) {
        return setProperty(ConditionType.CLIENT_USER_ID, value);
    }

    @Override
    public CompletableFuture<TwoStateVariableTypeNode> getEnabledStateNode() {
        return getVariableComponent("http://opcfoundation.org/UA/", "EnabledState").thenApply(TwoStateVariableTypeNode.class::cast);
    }

    @Override
    public CompletableFuture<LocalizedText> getEnabledState() {
        return getEnabledStateNode().thenCompose(UaVariableNode::getValue).thenApply(o -> cast(o, LocalizedText.class));
    }

    @Override
    public CompletableFuture<StatusCode> setEnabledState(LocalizedText value) {
        return getEnabledStateNode().thenCompose(node -> node.setValue(value));
    }

    @Override
    public CompletableFuture<ConditionVariableTypeNode> getQualityNode() {
        return getVariableComponent("http://opcfoundation.org/UA/", "Quality").thenApply(ConditionVariableTypeNode.class::cast);
    }

    @Override
    public CompletableFuture<StatusCode> getQuality() {
        return getQualityNode().thenCompose(UaVariableNode::getValue).thenApply(o -> cast(o, StatusCode.class));
    }

    @Override
    public CompletableFuture<StatusCode> setQuality(StatusCode value) {
        return getQualityNode().thenCompose(node -> node.setValue(value));
    }

    @Override
    public CompletableFuture<ConditionVariableTypeNode> getLastSeverityNode() {
        return getVariableComponent("http://opcfoundation.org/UA/", "LastSeverity").thenApply(ConditionVariableTypeNode.class::cast);
    }

    @Override
    public CompletableFuture<UShort> getLastSeverity() {
        return getLastSeverityNode().thenCompose(UaVariableNode::getValue).thenApply(o -> cast(o, UShort.class));
    }

    @Override
    public CompletableFuture<StatusCode> setLastSeverity(UShort value) {
        return getLastSeverityNode().thenCompose(node -> node.setValue(value));
    }

    @Override
    public CompletableFuture<ConditionVariableTypeNode> getCommentNode() {
        return getVariableComponent("http://opcfoundation.org/UA/", "Comment").thenApply(ConditionVariableTypeNode.class::cast);
    }

    @Override
    public CompletableFuture<LocalizedText> getComment() {
        return getCommentNode().thenCompose(UaVariableNode::getValue).thenApply(o -> cast(o, LocalizedText.class));
    }

    @Override
    public CompletableFuture<StatusCode> setComment(LocalizedText value) {
        return getCommentNode().thenCompose(node -> node.setValue(value));
    }
}
