#
# Copyright (C) 2020 Grakn Labs
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as
# published by the Free Software Foundation, either version 3 of the
# License, or (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#

load("@graknlabs_dependencies//tool/release:rules.bzl", "release_validate_deps")
load("@graknlabs_bazel_distribution//github:rules.bzl", "deploy_github")

exports_files(
    ["VERSION", "deployment.properties", "RELEASE_TEMPLATE.md"],
    visibility = ["//visibility:public"]
)

deploy_github(
    name = "deploy-github",
    release_description = "//:RELEASE_TEMPLATE.md",
    title = "Graql",
    title_append_version = True,
    deployment_properties = "//:deployment.properties",
)

release_validate_deps(
    name = "release-validate-deps",
    refs = "@graknlabs_graql_workspace_refs//:refs.json",
    tagged_deps = [
        "@graknlabs_common",
    ],
    tags = ["manual"]  # in order for bazel test //... to not fail
)