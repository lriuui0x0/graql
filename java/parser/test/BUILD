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

load("@graknlabs_dependencies//tool/checkstyle:rules.bzl", "checkstyle_test")

java_test(
    name = "parser-test",
    test_class = "graql.lang.parser.test.ParserTest",
    srcs = ["ParserTest.java"],
    deps = [
        "//java:graql",
        "//java/common:common",
        "//java/pattern:pattern",
        "//java/query:query",
        "@graknlabs_common//:common",
        "@maven//:org_hamcrest_hamcrest_library",
    ],
    size = "small",
)

checkstyle_test(
    name = "checkstyle",
    targets = [
        ":parser-test",
    ]
)