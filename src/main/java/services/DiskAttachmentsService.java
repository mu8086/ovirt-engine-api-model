/*
Copyright (c) 2016 Red Hat, Inc.

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

package services;

import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;

import types.DiskAttachment;

/**
 * This service manages the set of disks attached to a virtual machine. Each attached disk is represented by a
 * <<DiskAttachment,types/disk-attachment>>, containing the bootable flag, the disk interface and the reference to
 * the disk.
 */
@Service
public interface DiskAttachmentsService {
    /**
     * Adds a new disk attachment to the virtual machine. The `attachment` parameter can contain just a reference, if
     * the disk already exists:
     *
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <passDiscard>true</passDiscard>
     *   <interface>ide</interface>
     *   <disk id="123"/>
     * </disk_attachment>
     * ----
     *
     * Or it can contain the complete representation of the disk, if the disk doesn't exist yet:
     *
     * [source,xml]
     * ----
     * <disk_attachment>
     *   <bootable>true</bootable>
     *   <passDiscard>true</passDiscard>
     *   <interface>ide</interface>
     *   <disk>
     *     <name>mydisk</name>
     *     <provisioned_size>1024</provisioned_size>
     *     ...
     *   </disk>
     * </disk_attachment>
     * ----
     *
     * In this case the disk will be created and then attached to the virtual machine.
     */
    interface Add {
        @In @Out DiskAttachment attachment();
    }

    /**
     * List the disk that are attached to the virtual machine.
     */
    interface List {
        @Out DiskAttachment[] attachments();
    }

    /**
     * Reference to the service that manages a specific attachment.
     */
    @Service DiskAttachmentService attachment(String id);
}
