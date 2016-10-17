/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package types;

import org.ovirt.api.metamodel.annotations.Link;
import org.ovirt.api.metamodel.annotations.Type;

/**
 * Represents virtual NUMA node.
 *
 * An example XML representation:
 *
 * [source, xml]
 * ----
 * <vm_numa_node href="/ovirt-engine/api/vms/f1aa8209/numanodes/706cb6b0" id="706cb6b0">
 *   <cpu>
 *     <cores>
 *       <core>
 *         <index>0</index>
 *       </core>
 *     </cores>
 *   </cpu>
 *   <index>0</index>
 *   <memory>1024</memory>
 *   <numa_node_pins>
 *     <numa_node_pin>
 *       <host_numa_node id="007cf1ab"/>
 *       <index>0</index>
 *       <pinned>true</pinned>
 *     </numa_node_pin>
 *   </numa_node_pins>
 *   <vm href="/ovirt-engine/api/vms/f1aa8209" id="f1aa8209"/>
 * </vm_numa_node>
 * ----
 *
 * @author Andrej Krejcir <akrejcir@redhat.com>
 * @date 14 Sep 2016
 * @status added
 */
@Type
public interface VirtualNumaNode extends NumaNode {
    NumaNodePin[] numaNodePins();

    @Link Vm vm();
}