/*
 * Copyright 2013 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

$(function () {
    var $content = $('.content');
    var $sidebar = $('.sidebar');
    var $sidebarToggle = $('.brand-icon');
    var $footer = $('.footer');
    var $navLink = $('.content-nav a');

    function hideSidebar() {
        $sidebar.hide();
        $content.removeClass('content-sidebar-visible');
        $footer.removeClass('footer-sidebar-visible');
    }

    function showSidebar() {
        $sidebar.show();
        $content.addClass('content-sidebar-visible');
        $footer.addClass('footer-sidebar-visible');
    }

    // bind events

    $sidebarToggle.on('click', function () {
        if ($sidebar.is(':visible')) {
            hideSidebar();
        } else {
            showSidebar();
        }
    });
    $navLink.on('click', function (e) {
        if (!$sidebar.is(':visible')) {
            e.preventDefault();
            location.href = $(this).attr('href') + "?sidebar=hidden";
        }
    });

    // initialize

    if (location.search.indexOf('sidebar=hidden') !== -1) {
        hideSidebar();
    }

    $('pre').addClass('prettyprint');
    prettyPrint();

    $('table').wrap('<div class="table-responsive"></div>');
});
