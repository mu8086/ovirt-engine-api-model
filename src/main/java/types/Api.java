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

package types;

import java.util.Date;

import org.ovirt.api.metamodel.annotations.Type;

/**
 * The summary of the API.
 *
 * To get the summary of the API send a request like this:
 *
 * ....
 * GET /ovirt-engine/api
 * ....
 *
 * The result will be like this:
 *
 * [source,xml]
 * ----
 * <api>
 *   <link rel="hosts" href="/ovirt-engine/api/hosts"/>
 *   <link rel="vms" href="/ovirt-engine/api/vms"/>
 *   ...
 *   <product_info>
 *     <name>oVirt Engine</name>
 *     <vendor>ovirt.org</vendor>
 *     <version>
 *       <build>0</build>
 *       <full_version>4.1.0_master</full_version>
 *       <major>4</major>
 *       <minor>1</minor>
 *       <revision>0</revision>
 *     </version>
 *   </product_info>
 *   <special_objects>
 *     <link rel="templates/blank" href="..."/>
 *     <link rel="tags/root" href="..."/>
 *   </special_objects>
 *   <summary>
 *     <vms>
 *       <total>10</total>
 *       <active>3</active>
 *     </vms>
 *     <hosts>
 *       <total>2</total>
 *       <active>2</active>
 *     </hosts>
 *     <users>
 *       <total>8</total>
 *       <active>2</active>
 *     </users>
 *     <storage_domains>
 *       <total>2</total>
 *       <active>2</active>
 *     </storage_domains>
 *   </summary>
 *   <time>2016-12-12T12:22:25.866+01:00</time>
 * </api>
 * ----
 *
 * @author Piotr Kliczewski <pkliczew@redhat.com>
 * @date 12 Dec 2016
 * @status added
 */
@Type
public interface Api {
    /**
     * References to special objects, like the blank template and the root of the hierarchy of tags.
     */
    SpecialObjects specialObjects();

    /**
     * Information about the product, like its name, the name of the vendor and the version.
     */
    ProductInfo productInfo();

    /**
     * A summary containing the total number of relevant objects, like virtual machines, hosts and storage domains.
     */
    ApiSummary summary();

    /**
     * The date and time when this information was generated.
     */
    Date time();
}
