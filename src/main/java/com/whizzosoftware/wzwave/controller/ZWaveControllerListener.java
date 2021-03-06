/*
 *******************************************************************************
 * Copyright (c) 2013 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************
*/
package com.whizzosoftware.wzwave.controller;

import com.whizzosoftware.wzwave.node.NodeInfo;
import com.whizzosoftware.wzwave.node.ZWaveEndpoint;

/**
 * Listener interface for Z-Wave related events.
 *
 * @author Dan Noguerol
 */
public interface ZWaveControllerListener {
    /**
     * Callback when a new Z-Wave node has been discovered and interrogated.
     *
     * @param node the new Z-Wave node
     */
    void onZWaveNodeAdded(ZWaveEndpoint node);

    /**
     * Callback when an existing Z-Wave node is updated.
     *
     * @param node the updated Z-Wave node
     */
    void onZWaveNodeUpdated(ZWaveEndpoint node);

    /**
     * Callback when the initialization of the Z-Wave network has failed.
     *
     * @param t the cause
     */
    void onZWaveConnectionFailure(Throwable t);

    /**
     * Callback when the library has determined information about the Z-Wave controller.
     *
     * @param libraryVersion the library version of the controller
     * @param homeId the home ID of the controller
     * @param nodeId the node ID of the controller
     */
    void onZWaveControllerInfo(String libraryVersion, Integer homeId, Byte nodeId);

    /**
     * Callback when the Z-Wave controller has started network inclusion mode.
     */
    void onZWaveInclusionStarted();

    /**
     * Callback when a the Z-Wave controller has either successfully or unsuccessfully included a new node. This
     * call will be received prior to the node interview.
     *
     * @param nodeInfo information about the new node
     * @param success whether the inclusion was successful
     */
    void onZWaveInclusion(NodeInfo nodeInfo, boolean success);

    /**
     * Callback when the Z-Wave controller has stopped network inclusion mode.
     */
    void onZWaveInclusionStopped();

    /**
     * Callback when the Z-Wave controller has started network exclusion mode.
     */
    void onZWaveExclusionStarted();

    /**
     * Callback when the Z-Wave controller has either successfully or unsuccessfully excluded a node.
     *
     * @param nodeInfo information about the new node
     * @param success whether the exclusion was successful
     */
    void onZWaveExclusion(NodeInfo nodeInfo, boolean success);

    /**
     * Callback when the Z-Wave controller has stopped network exclusion mode.
     */
    void onZWaveExclusionStopped();
}
