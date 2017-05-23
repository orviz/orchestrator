# Intro 

VizGrimoireJS aims at providing a framework for software metrics visualization using HTML, 
CSS and JavaScript as main technologies.

It was born as a complement to the outcomes of VizGrimoireR project (now GrimoireLib), 
whose main focus is to parse information from any of the tools found in Metrics Grimoire 
project.

## Q. What libraries are used by this front-end?

[![Jenkins](https://img.shields.io/jenkins/s/https/ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish.svg?maxAge=2592000&style=flat-square)](https://ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish/)
[![Jenkins tests](https://img.shields.io/jenkins/t/https/ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish.svg?maxAge=2592000&style=flat-square)](https://ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish/)
[![Jenkins coverage](https://img.shields.io/jenkins/c/https/ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish.svg?maxAge=2592000&style=flat-square)](https://ci.cloud.reply.eu/jenkins/job/INDIGO/job/orchestrator-publish/)

## Q. How do I generate the HTML?

The INDIGO PaaS Orchestrator is a component of the PaaS layer that allows to instantiate resources on Cloud Management Frameworks (like [OpenStack](https://www.openstack.org/) and [OpenNebula](http://opennebula.org/)) and [Mesos](http://mesos.apache.org/) clusters.

It takes the deployment requests, expressed through templates written in [TOSCA YAML Simple Profile v1.0](http://docs.oasis-open.org/tosca/TOSCA-Simple-Profile-YAML/v1.0/TOSCA-Simple-Profile-YAML-v1.0.html), and deploys them on the best cloud site available. In order to do that
 1. it gathers SLAs, monitoring info and other data from other platform services,
 2. it asks to the cloud provider ranker for a list of the best cloud sites.

make clean

## Q. Where do I include the JSON files?

The PaaS Orchestrator needs the presence of the following INDIGO services:

 * [**SLAM** (SLA Manager)](https://indigo-dc.gitbooks.io/slam/content): allows to retrieve all the SLAs of the user
 * [**CMDB** (Configuration Manager DataBase)](https://indigo-dc.gitbooks.io/cmdb/content): contains all the cloud sites information, like the identity endpoint, the OCCI endpoint, etc...
 * [**Zabbix Wrapper** (REST wrapper for Zabbix)](https://indigo-dc.gitbooks.io/monitoring/content#1-zabbix-wrapper): allows to retrieve monitoring metrics to zabbix through a REST interface
 * [**CPR** (Cloud Provider Ranker)](https://www.gitbook.com/book/indigo-dc/cloud-provider-ranker/content): it receives all the information retrieved from the aforementioned services and provides the ordered list of the best sites

### GUIDES
* [How to build](gitbook/how_to_build.md)
* [How to deploy](gitbook/how_to_deploy.md)
* [How to upgrade](gitbook/how_to_upgrade.md)
* [Service Reference Card](gitbook/service_reference_card.md)
