package grails.plugin.scaffolding.registry.output

import grails.plugin.scaffolding.model.property.DomainProperty
import grails.plugin.scaffolding.registry.DomainOutputRenderer
import grails.util.GrailsNameUtils

/**
 * The renderer chosen for displaying domain properties when no other
 * renderers support the given property
 *
 * @author James Kleeh
 */
class DefaultOutputRenderer implements DomainOutputRenderer {

    protected String buildPropertyPath(DomainProperty property) {
        StringBuilder sb = new StringBuilder()
        sb.append(GrailsNameUtils.getPropertyName(property.rootBeanType)).append('.')
        sb.append(property.pathFromRoot)
        sb.toString()
    }

    @Override
    boolean supports(DomainProperty property) {
        true
    }

    @Override
    Closure renderListOutput(DomainProperty property) {
        renderOutput(property)
    }

    @Override
    Closure renderOutput(DomainProperty property) {
        { ->
            span("\${${buildPropertyPath(property)}}")
        }
    }
}
