layout 'layouts/main.tpl',
        pageTitle: 'Cloud Foundry Demo',
        mainBody: contents {
   div(class:'jumbotron'){
     h1('Cloud Foundry Demo')
       p(class:'lead','This application is running in Cloud Foundry with services')
   }
       

     
	h2('Associated Services')
	table(class:'table table-striped'){
		thead{
			tr{
				th('Name')
				th('Type')
				th('Plan')
			}
		}
		tbody {
			services.each { service ->
				tr{
				    td{
				    	a(href:'service/'+service.name, service.name)
				    }
					td(service.label)
					td(service.plan)
				}
	   		}
	   	}
	}
  
}