/*
 * Copyright © 2015-2019 Santer Reply S.p.A.
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

package it.reply.orchestrator.dto.policies;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.checkerframework.checker.nullness.qual.NonNull;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GenericToscaPolicy implements ToscaPolicy {

  @NonNull
  @NotNull
  private String type;

  @NonNull
  @NotNull
  private Set<String> targets = new HashSet<>();

  @Deprecated
  protected GenericToscaPolicy() {
    targets = new HashSet<>();
  }

  protected GenericToscaPolicy(@NonNull String type) {
    this();
    this.type = Objects.requireNonNull(type);
  }
}