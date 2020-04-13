package jpatest.filter;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.FilterChain;
import io.micronaut.http.filter.HttpFilter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

@Filter("/**")
public class MyFilter implements HttpServerFilter {
    private final TraceService traceService;

    public MyFilter(TraceService traceService) {
        this.traceService = traceService;
    }

    //使用Filter失败了
    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        return traceService.trace(request)
                .switchMap(aBoolean -> chain.proceed(request))
                .doOnNext(res ->
                        res.getHeaders().add("X-Trace-Enabled", "true").add("Content-Length","333")
                );

    }

}
