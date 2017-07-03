layout 'layouts/main.tpl',
        pageTitle: vcapService.name + ' service',
        mainBody: contents {
   div(class:'jumbotron'){
     h1(vcapService.name + ' service details')
       p(class:'lead',){
       	a(href:'/', 'Return home')
       }
   }
       

	ul(class:'list-group'){
		li(class:'list-group-item'){
			h4(class: 'list-group-item-heading', 'Label')
			p(class: 'list-group-item-text', vcapService.label)
		}
		li(class:'list-group-item'){
			h4(class: 'list-group-item-heading', 'Plan')
			p(class: 'list-group-item-text', vcapService.plan)
		}
		li(class:'list-group-item'){
			h4(class: 'list-group-item-heading', 'Credentials')
			ul(class:'list-group'){
				li(class:'list-group-item'){
					h5(class: 'list-group-item-heading', 'URI')
					p(class: 'list-group-item-text', vcapService.credentials.uri)
				}
				li(class:'list-group-item'){
					h5(class: 'list-group-item-heading', 'Hostname')
					p(class: 'list-group-item-text', vcapService.credentials.hostname)
				}
				li(class:'list-group-item'){
					h5(class: 'list-group-item-heading', 'Port')
					p(class: 'list-group-item-text', vcapService.credentials.port)
				}
				li(class:'list-group-item'){
					h5(class: 'list-group-item-heading', 'username')
					p(class: 'list-group-item-text', vcapService.credentials.username)
				}
				li(class:'list-group-item'){
					h5(class: 'list-group-item-heading', 'password')
					p(class: 'list-group-item-text', vcapService.credentials.password)
				}
			}
		}
		li(class:'list-group-item'){
			h4(class: 'list-group-item-heading', 'Tags')
			ol{
				vcapService.tags.each { tag ->
					li(class: 'list-group-item-text', tag)
				}
			}
		}
	}
  
}