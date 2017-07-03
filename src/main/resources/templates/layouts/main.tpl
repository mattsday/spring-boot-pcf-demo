yieldUnescaped '<!DOCTYPE html>'

html {
    head {
        title(pageTitle)
        meta(name: 'viewport', content:'width=device-width, initial-scale=1')
        link(rel: 'stylesheet', href: '/webjars/bootstrap/css/bootstrap.min.css')
    }

    body {
            div(class: 'container') {
                div(class: 'header clearfix') {
                    nav{
                    ul(class: 'nav nav-pills pull-right'){
                             li(role: 'presentation', class: 'active') { a(href:'/', 'Home') }
                        }
                }
                h3(class: 'text-muted', 'HSBC')
            }

            mainBody()


        }

        script(src: '/webjars/jqueryjquery.min.js') { }
        script(src: '/webjars/bootstrap/js/bootstrap.min.js') { }

    }
}